package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.TestingTypesBcValidateTypesBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.TestingTypesBcService;
import java.math.BigDecimal;
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
@RequestMapping(value = "/testingTypes_bc")
@RequiredArgsConstructor
public class TestingTypesBcController {

  @Autowired private ConfigService configService;

  @Autowired private TestingTypesBcService testingtypesBcService;

  @RequestMapping(value = "/validateTypes", method = RequestMethod.POST)
  public ResponseEntity<?> validateTypes(
      @RequestBody TestingTypesBcValidateTypesBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getTypeBoolean())) {
        errorParams.add("typeBoolean");
      }
      if (Objects.isNull(bodyRequest.getTypeDecimal())) {
        errorParams.add("typeDecimal");
      }
      if (Objects.isNull(bodyRequest.getTypeInteger())) {
        errorParams.add("typeInteger");
      }
      if (Objects.isNull(bodyRequest.getTypeList())) {
        errorParams.add("typeList");
      }
      if (Objects.isNull(bodyRequest.getTypeLong())) {
        errorParams.add("typeLong");
      }
      if (Objects.isNull(bodyRequest.getTypeLongText())) {
        errorParams.add("typeLongText");
      }
      if (Objects.isNull(bodyRequest.getTypePassword())) {
        errorParams.add("typePassword");
      }
      if (Objects.isNull(bodyRequest.getTypeString())) {
        errorParams.add("typeString");
      }
      if (Objects.isNull(bodyRequest.getTypeObject())) {
        errorParams.add("typeObject");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Boolean typeBoolean = bodyRequest.getTypeBoolean();
      BigDecimal typeDecimal = bodyRequest.getTypeDecimal();
      Integer typeInteger = bodyRequest.getTypeInteger();
      List<TestingTypesBcValidateTypesInTypeListDataDto> typeList = bodyRequest.getTypeList();
      Long typeLong = bodyRequest.getTypeLong();
      String typeLongText = bodyRequest.getTypeLongText();
      String typePassword = bodyRequest.getTypePassword();
      String typeString = bodyRequest.getTypeString();

      TestingTypesBcValidateTypesInTypeObjectDto typeObject = bodyRequest.getTypeObject();

      BackendResponse<?> response =
          testingtypesBcService.executeValidateTypes(
              typeBoolean,
              typeDecimal,
              typeInteger,
              typeList,
              typeLong,
              typeLongText,
              typePassword,
              typeString,
              typeObject);

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

  @RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
  public ResponseEntity<?> deleteAll() {

    try {

      testingtypesBcService.executeDeleteAll();

      return new ResponseEntity(HttpStatus.OK);
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
