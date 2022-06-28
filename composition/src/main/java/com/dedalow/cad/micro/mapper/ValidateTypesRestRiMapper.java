package com.dedalow.cad.micro.mapper;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateTypesRestRiMicroRestBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.proxy.ValidateTypesRestRiProxy;
import feign.FeignException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidateTypesRestRiMapper {

  @Autowired ValidateTypesRestRiProxy validateTypesRestRiProxy;

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
      throws CadException {

    ValidateTypesRestRiMicroRestBodyRequestDto bodyInput =
        ValidateTypesRestRiMicroRestBodyRequestDto.builder()
            .typeBoolean(typeBoolean)
            .typeDecimal(typeDecimal)
            .typeInteger(typeInteger)
            .typeList(typeList)
            .typeLong(typeLong)
            .typeLongText(typeLongText)
            .typeObject(typeObject)
            .typePassword(typePassword)
            .typeString(typeString)
            .build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {
      ResponseEntity<?> response = validateTypesRestRiProxy.microRest(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();
    } catch (FeignException e) {
      try {
        backendResponseBuilder.statusCode(e.status());
        String responseJson = e.contentUTF8();
        switch (e.status()) {
          case 500:
            throw new CadException("ERR-REST-010");
          default:
            throw new CadException("ERR-COMP-013");
        }
      } catch (Exception ex) {
        throw e;
      }
    }
  }
}
