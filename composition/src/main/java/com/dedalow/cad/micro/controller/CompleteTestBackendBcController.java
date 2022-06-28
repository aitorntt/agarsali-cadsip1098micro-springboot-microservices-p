package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.CompleteTestBackendBcAddUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.CompleteTestBackendBcCompleteBackendExampleBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.CompleteTestBackendBcCrudsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.CompleteTestBackendBcCustomsAndRestBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.CompleteTestBackendBcService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/completeTestBackend_bc")
@RequiredArgsConstructor
public class CompleteTestBackendBcController {

  @Autowired private ConfigService configService;

  @Autowired private CompleteTestBackendBcService completetestbackendBcService;

  @RequestMapping(value = "/customsAndRest", method = RequestMethod.POST)
  public ResponseEntity<?> customsAndRest(
      @RequestBody CompleteTestBackendBcCustomsAndRestBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      BackendResponse<?> response = completetestbackendBcService.executeCustomsAndRest(username);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "COMP");
      exceptionResponse.setCode(
          StringUtils.hasText(exceptionResponse.getCode()) ? exceptionResponse.getCode() : null);
      exceptionResponse.setMessage(
          StringUtils.hasText(exceptionResponse.getMessage())
              ? exceptionResponse.getMessage()
              : null);
      log.error(
          exceptionResponse.getCode() + " - " + exceptionResponse.getMessage(), exceptionResponse);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
  }

  @RequestMapping(value = "/completeBackendExample", method = RequestMethod.POST)
  public ResponseEntity<?> completeBackendExample(
      @RequestBody CompleteTestBackendBcCompleteBackendExampleBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      BackendResponse<?> response =
          completetestbackendBcService.executeCompleteBackendExample(username);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "COMP");
      exceptionResponse.setCode(
          StringUtils.hasText(exceptionResponse.getCode()) ? exceptionResponse.getCode() : null);
      exceptionResponse.setMessage(
          StringUtils.hasText(exceptionResponse.getMessage())
              ? exceptionResponse.getMessage()
              : null);
      log.error(
          exceptionResponse.getCode() + " - " + exceptionResponse.getMessage(), exceptionResponse);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ResponseEntity<?> addUser(
      @RequestBody CompleteTestBackendBcAddUserBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      BackendResponse<?> response = completetestbackendBcService.executeAddUser(username);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "COMP");
      exceptionResponse.setCode(
          StringUtils.hasText(exceptionResponse.getCode()) ? exceptionResponse.getCode() : null);
      exceptionResponse.setMessage(
          StringUtils.hasText(exceptionResponse.getMessage())
              ? exceptionResponse.getMessage()
              : null);
      log.error(
          exceptionResponse.getCode() + " - " + exceptionResponse.getMessage(), exceptionResponse);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
  }

  @RequestMapping(value = "/cruds", method = RequestMethod.POST)
  public ResponseEntity<?> cruds(
      @RequestBody CompleteTestBackendBcCrudsBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      BackendResponse<?> response = completetestbackendBcService.executeCruds(id);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "COMP");
      exceptionResponse.setCode(
          StringUtils.hasText(exceptionResponse.getCode()) ? exceptionResponse.getCode() : null);
      exceptionResponse.setMessage(
          StringUtils.hasText(exceptionResponse.getMessage())
              ? exceptionResponse.getMessage()
              : null);
      log.error(
          exceptionResponse.getCode() + " - " + exceptionResponse.getMessage(), exceptionResponse);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
  }
}
