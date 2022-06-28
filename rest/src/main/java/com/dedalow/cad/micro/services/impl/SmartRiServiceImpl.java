package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.SmartRiLoginOkResponseDto;
import com.dedalow.cad.micro.commons.dto.response.SmartRiUserDetailOkResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.commons.util.SslVerificationHelper;
import com.dedalow.cad.micro.services.SmartRiService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SmartRiServiceImpl implements SmartRiService {

  @Override
  public BackendResponse<?> executeLogin(String username, String password) throws Exception {
    return executeLogin(username, password, true);
  }

  @Override
  public BackendResponse<?> executeLogin(String username, String password, boolean sslVerification)
      throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    SSLContext sc;
    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    HttpHeaders headersVar = new HttpHeaders();
    String path = "https://cad-common-wiremock.caddev.everis.com/api/user/login";

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path);

    path = builder.toUriString();

    headersVar.set("Content-Type", "application/json");

    Map<String, Object> entityBodyData = new HashMap<String, Object>();

    entityBodyData.put("username", username);

    entityBodyData.put("password", password);
    HttpEntity<?> entity = new HttpEntity<>(entityBodyData, headersVar);

    try {
      path = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new Exception("ERR-REST-011");
    }

    try {
      sc = SSLContext.getInstance("SSL");
      SslVerificationHelper svh = new SslVerificationHelper();

      if (!sslVerification) {
        svh.disableSslVerification(sc);
      } else {
        HttpComponentsClientHttpRequestFactory requestFactory =
            new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
      }

      restTemplate
          .getMessageConverters()
          .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
      ResponseEntity<String> response =
          restTemplate.exchange(path, HttpMethod.POST, entity, String.class);

      svh.enableSslVerification(sc);

      String responseJson = null;
      if (Objects.isNull(response.getBody())) {
        responseJson = "{}";
      } else {
        responseJson = response.getBody();
      }

      backendResponseBuilder.statusCode(response.getStatusCodeValue());
      switch (response.getStatusCodeValue()) {
        case 200:
          try {
            backendResponseBuilder.body(
                ObjectMapperUtil.getMapper()
                    .readValue(responseJson, SmartRiLoginOkResponseDto.class));

          } catch (Exception ex) {
            throw new CadException("ERR-REST-012");
          }

          backendResponseBuilder.isOk(true);
          backendResponseBuilder.message("ERR-REST-010");
          return backendResponseBuilder.build();
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (CadException e) {
      throw e;
    } catch (HttpClientErrorException | HttpServerErrorException e) {

      backendResponseBuilder.statusCode(e.getStatusCode().value());
      backendResponseBuilder.isOk(false);
      String responseJson = e.getResponseBodyAsString();
      if (StringUtils.isEmpty(responseJson)) {
        responseJson = "{}";
      }

      switch (e.getStatusCode().value()) {
        case 404:
          throw new CadException("No se encuentra");
        case 403:
          throw new CadException("Acceso prohibido");
        case 201:
          throw new CadException("Usuario creado");
        case 401:
          throw new CadException("Usuario no autorizado");
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (UnknownHttpStatusCodeException e) {
      throw new Exception("ERR-REST-006");
    } catch (ResourceAccessException e) {
      if (e.getCause().getClass().equals(SSLHandshakeException.class) && sslVerification) {
        return executeLogin(username, password, false);
      } else {
        throw new Exception("ERR-REST-008");
      }
    } catch (Exception e) {
      throw new CadException("ERR-REST-010");
    }
  }

  @Override
  public BackendResponse<?> executeUserDetail(String authorization, String username)
      throws Exception {
    return executeUserDetail(authorization, username, true);
  }

  @Override
  public BackendResponse<?> executeUserDetail(
      String authorization, String username, boolean sslVerification) throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    SSLContext sc;
    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    HttpHeaders headersVar = new HttpHeaders();
    String path = "https://cad-common-wiremock.caddev.everis.com/api/user/getDetail";

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path);
    if (Objects.nonNull(authorization) && !authorization.toString().isEmpty()) {
      headersVar.set("Authorization", String.valueOf(authorization));
    }

    if (Objects.nonNull(username) && !username.toString().isEmpty()) {
      if (username.getClass().equals(ArrayList.class)) {
        builder.queryParam(
            "username", username.toString().substring(1, username.toString().length() - 1));
      } else {
        builder.queryParam("username", username);
      }
    }
    path = builder.toUriString();

    headersVar.set("Content-Type", "application/json");

    Map<String, Object> entityBodyData = new HashMap<String, Object>();
    HttpEntity<?> entity = new HttpEntity<>(entityBodyData, headersVar);

    try {
      path = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new Exception("ERR-REST-011");
    }

    try {
      sc = SSLContext.getInstance("SSL");
      SslVerificationHelper svh = new SslVerificationHelper();

      if (!sslVerification) {
        svh.disableSslVerification(sc);
      } else {
        HttpComponentsClientHttpRequestFactory requestFactory =
            new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
      }

      restTemplate
          .getMessageConverters()
          .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
      ResponseEntity<String> response =
          restTemplate.exchange(path, HttpMethod.GET, entity, String.class);

      svh.enableSslVerification(sc);

      String responseJson = null;
      if (Objects.isNull(response.getBody())) {
        responseJson = "{}";
      } else {
        responseJson = response.getBody();
      }

      backendResponseBuilder.statusCode(response.getStatusCodeValue());
      switch (response.getStatusCodeValue()) {
        case 200:
          try {
            backendResponseBuilder.body(
                ObjectMapperUtil.getMapper()
                    .readValue(responseJson, SmartRiUserDetailOkResponseDto.class));

          } catch (Exception ex) {
            throw new CadException("ERR-REST-012");
          }

          backendResponseBuilder.isOk(true);
          backendResponseBuilder.message("ERR-REST-010");
          return backendResponseBuilder.build();
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (CadException e) {
      throw e;
    } catch (HttpClientErrorException | HttpServerErrorException e) {

      backendResponseBuilder.statusCode(e.getStatusCode().value());
      backendResponseBuilder.isOk(false);
      String responseJson = e.getResponseBodyAsString();
      if (StringUtils.isEmpty(responseJson)) {
        responseJson = "{}";
      }

      switch (e.getStatusCode().value()) {
        case 401:
          throw new CadException("Usuario no autorizado");
        case 404:
          throw new CadException("No se encuentra");
        case 403:
          throw new CadException("Acceso Prohibido");
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (UnknownHttpStatusCodeException e) {
      throw new Exception("ERR-REST-006");
    } catch (ResourceAccessException e) {
      if (e.getCause().getClass().equals(SSLHandshakeException.class) && sslVerification) {
        return executeUserDetail(authorization, username, false);
      } else {
        throw new Exception("ERR-REST-008");
      }
    } catch (Exception e) {
      throw new CadException("ERR-REST-010");
    }
  }
}
