package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.TestingIncrementalConfigBcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/testingIncrementalConfig_bc")
@RequiredArgsConstructor
public class TestingIncrementalConfigBcController {

  @Autowired private ConfigService configService;

  @Autowired private TestingIncrementalConfigBcService testingincrementalconfigBcService;

  @RequestMapping(value = "/sumaPares", method = RequestMethod.POST)
  public ResponseEntity<?> sumaPares() {

    try {

      BackendResponse<?> response = testingincrementalconfigBcService.executeSumaPares();

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

  @RequestMapping(value = "/countGeneros", method = RequestMethod.POST)
  public ResponseEntity<?> countGeneros() {

    try {

      BackendResponse<?> response = testingincrementalconfigBcService.executeCountGeneros();

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
