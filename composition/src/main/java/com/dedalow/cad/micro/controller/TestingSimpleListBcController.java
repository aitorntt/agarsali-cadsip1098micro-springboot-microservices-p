package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.TestingSimpleListBcTestSimpleListBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.TestingSimpleListBcService;
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
@RequestMapping(value = "/testingSimpleList_bc")
@RequiredArgsConstructor
public class TestingSimpleListBcController {

  @Autowired private ConfigService configService;

  @Autowired private TestingSimpleListBcService testingsimplelistBcService;

  @RequestMapping(value = "/testSimpleList", method = RequestMethod.POST)
  public ResponseEntity<?> testSimpleList(
      @RequestBody TestingSimpleListBcTestSimpleListBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getModValue())) {
        errorParams.add("modValue");
      }
      if (Objects.isNull(bodyRequest.getNames())) {
        errorParams.add("names");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer modValue = bodyRequest.getModValue();
      List<String> names = bodyRequest.getNames();

      BackendResponse<?> response =
          testingsimplelistBcService.executeTestSimpleList(modValue, names);

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
