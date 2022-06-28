package com.dedalow.cad.micro.mapper;


import com.dedalow.cad.micro.commons.dto.request.SmartRiLoginBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.proxy.SmartRiProxy;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SmartRiMapper {

  @Autowired SmartRiProxy smartRiProxy;

  public BackendResponse<?> executeLogin(String username, String password) throws CadException {

    SmartRiLoginBodyRequestDto bodyInput =
        SmartRiLoginBodyRequestDto.builder().username(username).password(password).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {
      ResponseEntity<?> response = smartRiProxy.login(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();
    } catch (FeignException e) {
      try {
        backendResponseBuilder.statusCode(e.status());
        String responseJson = e.contentUTF8();
        switch (e.status()) {
          case 404:
            throw new CadException("No se encuentra");
          case 403:
            throw new CadException("Acceso prohibido");
          case 201:
            throw new CadException("Usuario creado");
          case 401:
            throw new CadException("Usuario no autorizado");
          default:
            throw new CadException("ERR-COMP-013");
        }
      } catch (Exception ex) {
        throw e;
      }
    }
  }

  public BackendResponse<?> executeUserDetail(String authorization, String username)
      throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {
      ResponseEntity<?> response = smartRiProxy.userDetail(authorization, username);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();
    } catch (FeignException e) {
      try {
        backendResponseBuilder.statusCode(e.status());
        String responseJson = e.contentUTF8();
        switch (e.status()) {
          case 401:
            throw new CadException("Usuario no autorizado");
          case 404:
            throw new CadException("No se encuentra");
          case 403:
            throw new CadException("Acceso Prohibido");
          default:
            throw new CadException("ERR-COMP-013");
        }
      } catch (Exception ex) {
        throw e;
      }
    }
  }
}
