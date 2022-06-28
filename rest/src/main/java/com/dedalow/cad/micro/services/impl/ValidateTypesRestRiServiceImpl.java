package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.ValidateTypesRestRiMicroRestAuxOkResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ValidateTypesRestRiMicroRestOkResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.commons.util.SslVerificationHelper;
import com.dedalow.cad.micro.services.ValidateTypesRestRiService;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
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
public class ValidateTypesRestRiServiceImpl implements ValidateTypesRestRiService {

  @Override
  public BackendResponse<?> executeMicroRest(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto> typeList,
      Long typeLong,
      String typeLongText,
      ValidateTypesRestRiMicroRestInTypeObjectDto typeObject,
      String typePassword,
      String typeString)
      throws Exception {
    return executeMicroRest(
        typeBoolean,
        typeDecimal,
        typeInteger,
        typeList,
        typeLong,
        typeLongText,
        typeObject,
        typePassword,
        typeString,
        true);
  }

  @Override
  public BackendResponse<?> executeMicroRest(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto> typeList,
      Long typeLong,
      String typeLongText,
      ValidateTypesRestRiMicroRestInTypeObjectDto typeObject,
      String typePassword,
      String typeString,
      boolean sslVerification)
      throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    SSLContext sc;
    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    HttpHeaders headersVar = new HttpHeaders();
    String path = "https://cad-common-wiremock.caddev.everis.com/weather/getPrueba";

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path);

    path = builder.toUriString();

    headersVar.set("Content-Type", "application/json");

    Map<String, Object> entityBodyData = new HashMap<String, Object>();

    entityBodyData.put("typeBoolean", typeBoolean);

    entityBodyData.put("typeDecimal", typeDecimal);

    entityBodyData.put("typeInteger", typeInteger);

    entityBodyData.put("typeList", typeList);

    entityBodyData.put("typeLong", typeLong);

    entityBodyData.put("typeLongText", typeLongText);

    entityBodyData.put("typeObject", typeObject);

    entityBodyData.put("typePassword", typePassword);

    entityBodyData.put("typeString", typeString);
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
                    .readValue(responseJson, ValidateTypesRestRiMicroRestOkResponseDto.class));

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
        case 500:
          throw new CadException("ERR-REST-010");
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (UnknownHttpStatusCodeException e) {
      throw new Exception("ERR-REST-006");
    } catch (ResourceAccessException e) {
      if (e.getCause().getClass().equals(SSLHandshakeException.class) && sslVerification) {
        return executeMicroRest(
            typeBoolean,
            typeDecimal,
            typeInteger,
            typeList,
            typeLong,
            typeLongText,
            typeObject,
            typePassword,
            typeString,
            false);
      } else {
        throw new Exception("ERR-REST-008");
      }
    } catch (Exception e) {
      throw new CadException("ERR-REST-010");
    }
  }

  @Override
  public BackendResponse<?> executeMicroRestAux() throws Exception {
    return executeMicroRestAux(true);
  }

  @Override
  public BackendResponse<?> executeMicroRestAux(boolean sslVerification) throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    SSLContext sc;
    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    HttpHeaders headersVar = new HttpHeaders();
    String path = "https://cad-common-wiremock.caddev.everis.com/weather/getPrueba";

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path);

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
                    .readValue(responseJson, ValidateTypesRestRiMicroRestAuxOkResponseDto.class));

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
        case 500:
          throw new CadException("ERR-REST-010");
        default:
          throw new CadException("ERR-REST-013");
      }
    } catch (UnknownHttpStatusCodeException e) {
      throw new Exception("ERR-REST-006");
    } catch (ResourceAccessException e) {
      if (e.getCause().getClass().equals(SSLHandshakeException.class) && sslVerification) {
        return executeMicroRestAux(false);
      } else {
        throw new Exception("ERR-REST-008");
      }
    } catch (Exception e) {
      throw new CadException("ERR-REST-010");
    }
  }
}
