package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInPricesPriceDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInProductDto;
import com.dedalow.cad.micro.commons.dto.request.TestingObjectsBcGetProductsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.TestingObjectsBcSaveProductBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.TestingObjectsBcService;
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
@RequestMapping(value = "/testingObjects_bc")
@RequiredArgsConstructor
public class TestingObjectsBcController {

  @Autowired private ConfigService configService;

  @Autowired private TestingObjectsBcService testingobjectsBcService;

  @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
  public ResponseEntity<?> saveProduct(
      @RequestBody TestingObjectsBcSaveProductBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getProduct())) {
        errorParams.add("product");
      }
      if (Objects.isNull(bodyRequest.getPrices())) {
        errorParams.add("prices");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }

      TestingObjectsBcSaveProductInProductDto product = bodyRequest.getProduct();
      List<TestingObjectsBcSaveProductInPricesPriceDto> prices = bodyRequest.getPrices();

      BackendResponse<?> response = testingobjectsBcService.executeSaveProduct(product, prices);

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

  @RequestMapping(value = "/getProducts", method = RequestMethod.POST)
  public ResponseEntity<?> getProducts(
      @RequestBody TestingObjectsBcGetProductsBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getTypeId())) {
        errorParams.add("typeId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long typeId = bodyRequest.getTypeId();

      BackendResponse<?> response = testingobjectsBcService.executeGetProducts(typeId);

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
