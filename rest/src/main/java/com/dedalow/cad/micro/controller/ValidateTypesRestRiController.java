package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateTypesRestRiMicroRestBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.ValidateTypesRestRiService;
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
@RequestMapping(value = "/ValidateTypesRest_rm")
@RequiredArgsConstructor
public class ValidateTypesRestRiController {

  @Autowired private ConfigService configService;

  @Autowired private ValidateTypesRestRiService validatetypesrestRiService;

  @RequestMapping(value = "/microRest", method = RequestMethod.POST)
  public ResponseEntity<?> microRest(
      @RequestBody ValidateTypesRestRiMicroRestBodyRequestDto bodyRequest) {

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
      if (Objects.isNull(bodyRequest.getTypeObject())) {
        errorParams.add("typeObject");
      }
      if (Objects.isNull(bodyRequest.getTypePassword())) {
        errorParams.add("typePassword");
      }
      if (Objects.isNull(bodyRequest.getTypeString())) {
        errorParams.add("typeString");
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
      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto> typeList =
          bodyRequest.getTypeList();
      Long typeLong = bodyRequest.getTypeLong();
      String typeLongText = bodyRequest.getTypeLongText();

      ValidateTypesRestRiMicroRestInTypeObjectDto typeObject = bodyRequest.getTypeObject();
      String typePassword = bodyRequest.getTypePassword();
      String typeString = bodyRequest.getTypeString();

      BackendResponse<?> response =
          validatetypesrestRiService.executeMicroRest(
              typeBoolean,
              typeDecimal,
              typeInteger,
              typeList,
              typeLong,
              typeLongText,
              typeObject,
              typePassword,
              typeString);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "REST");
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

  @RequestMapping(value = "/microRestAux", method = RequestMethod.POST)
  public ResponseEntity<?> microRestAux() {

    try {

      BackendResponse<?> response = validatetypesrestRiService.executeMicroRestAux();

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "REST");
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
