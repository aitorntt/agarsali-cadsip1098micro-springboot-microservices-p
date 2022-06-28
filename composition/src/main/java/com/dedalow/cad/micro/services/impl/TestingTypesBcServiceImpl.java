package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestingTypesBcValidateTypesOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ValidateTypesRestRiMicroRestOkResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.mapper.ValidateTypesRestRiMapper;
import com.dedalow.cad.micro.services.TestingTypesBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestingTypesBcServiceImpl implements TestingTypesBcService {

  @Autowired SqlMapper sqlService;
  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired ValidateTypesRestRiMapper validateTypesRestRiService;

  @Override
  public BackendResponse<?> executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<TestingTypesBcValidateTypesInTypeListDataDto> typeList,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString,
      TestingTypesBcValidateTypesInTypeObjectDto typeObject)
      throws CadException {

    GetUsuarioOutOutputSQLResultDto usuario = null;

    ValidateTypesRestRiMicroRestOkResponseDto rest = null;
    BackendResponse<?> _backendResponse = null;

    try {

      sqlService.executeValidateTypes(
          typeBoolean, typeDecimal, typeInteger, typeLong, typeLongText, typePassword, typeString);

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      usuario = sqlService.executeGetUsuario(typeString);

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      sqlService.executeValidateObjects(
          ValidateObjectsInUserDto.builder()
              .name(usuario.getNombre())
              .age(usuario.getEdad())
              .build());

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      sqlService.executeValidateObjects(
          ValidateObjectsInUserDto.builder()
              .name(typeObject.getNombre())
              .age(typeObject.getEdad())
              .build());

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    Integer i = 0;
    do {
      try {

        sqlService.executeValidateList(typeList.get(i).getPrice());

      } catch (Exception e) {
        throw new CadException("ERR-COMP-001", e.getCause());
      }
      i++;
    } while (i < typeList.size());

    try {

      allExternalCodesEcService.executeValidateTypes(
          typeBoolean,
          typeDecimal,
          typeInteger,
          ObjectMapperUtil.convertValue(
              typeList,
              new TypeReference<List<AllExternalCodesEcValidateTypesInTypeListDataDto>>() {}),
          typeLong,
          typeLongText,
          ObjectMapperUtil.convertValue(
              typeObject, new TypeReference<AllExternalCodesEcValidateTypesInTypeObjectDto>() {}),
          typePassword,
          typeString);

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {
      _backendResponse =
          validateTypesRestRiService.executeMicroRest(
              typeBoolean,
              typeDecimal,
              typeInteger,
              ObjectMapperUtil.convertValue(
                  typeList,
                  new TypeReference<
                      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto>>() {}),
              typeLong,
              typeLongText,
              ObjectMapperUtil.convertValue(
                  typeObject, new TypeReference<ValidateTypesRestRiMicroRestInTypeObjectDto>() {}),
              typePassword,
              typeString);
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

        rest =
            ObjectMapperUtil.convertValue(
                _backendResponse.getBody(),
                new TypeReference<ValidateTypesRestRiMicroRestOkResponseDto>() {});
      }
    } catch (Exception e) {
      throw new CadException("error validateRest", e.getCause());
    }
    try {

      allExternalCodesEcService.executeEmptyExternal(rest.getData().getTypeValue());

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      sqlService.executeValidateObjects(
          ValidateObjectsInUserDto.builder()
              .name(rest.getData().getTypeName())
              .age(rest.getData().getTypeValue())
              .build());

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    for (Integer z = 0; z < rest.getData().getAddress().size(); z++) {
      try {

        allExternalCodesEcService.executeEmptyExternal(rest.getData().getAddress().get(z).getNum());

      } catch (Exception e) {
        throw new CadException("ERR-COMP-001", e.getCause());
      }
    }
    if (rest.getData().getTypeValue() < 10) {

    } else {
    }
    return BackendResponse.builder()
        .body(
            TestingTypesBcValidateTypesOkResponseResponseDto.builder()
                .typeName(rest.getData().getTypeName())
                .typeValue(rest.getData().getTypeValue())
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }

  @Override
  public void executeDeleteAll() throws CadException {

    try {

      sqlService.executeDeleteValidateTypes();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteValidateObjects();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteValidateList();

    } catch (Exception e) {
    }
  }
}
