package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.SaveProductCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.SaveProductCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.ProductCRUDService;
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
@RequestMapping(value = "/productCRUD")
@RequiredArgsConstructor
public class ProductCRUDController {

  @Autowired private ConfigService configService;

  @Autowired private ProductCRUDService productCRUDService;

  @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
  public ResponseEntity<?> saveProduct(@RequestBody SaveProductCRUDBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getInputDomain())) {
        errorParams.add("inputDomain");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }

      Product inputDomain = bodyRequest.getInputDomain();

      SaveProductCRUDOkResponseResponseDto response =
          SaveProductCRUDOkResponseResponseDto.builder()
              .outputDomainEntity(productCRUDService.executeSaveProduct(inputDomain))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "CRUD");
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
