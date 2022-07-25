package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestOutDataDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.EmptyResponse;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioOkResponseResponseDto;
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
    ValidateTypesRestRiMicroRestOutDataDto rest = null;
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse =
          sqlService.executeValidateTypes(
              typeBoolean,
              typeDecimal,
              typeInteger,
              typeLong,
              typeLongText,
              typePassword,
              typeString);
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      _backendResponse = sqlService.executeGetUsuario(typeString);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        usuario =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetUsuarioOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      _backendResponse =
          sqlService.executeValidateObjects(
              ValidateObjectsInUserDto.builder()
                  .name(usuario.getNombre())
                  .age(usuario.getEdad())
                  .build());
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      _backendResponse =
          sqlService.executeValidateObjects(
              ValidateObjectsInUserDto.builder()
                  .name(typeObject.getNombre())
                  .age(typeObject.getEdad())
                  .build());
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    Integer i = 0;
    do {
      try {

        _backendResponse = sqlService.executeValidateList(typeList.get(i).getPrice());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {

        }

      } catch (Exception e) {
        throw new CadException("ERR-COMP-001", e.getCause());
      }
      i++;
    } while (i < typeList.size());

    try {

      _backendResponse =
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
                  typeObject,
                  new TypeReference<AllExternalCodesEcValidateTypesInTypeObjectDto>() {}),
              typePassword,
              typeString);
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

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
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<ValidateTypesRestRiMicroRestOkResponseDto>() {})
                    .getData(),
                new TypeReference<ValidateTypesRestRiMicroRestOutDataDto>() {});
      }

    } catch (Exception e) {
      throw new CadException("error validateRest", e.getCause());
    }
    try {

      _backendResponse = allExternalCodesEcService.executeEmptyExternal(rest.getTypeValue());

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    try {

      _backendResponse =
          sqlService.executeValidateObjects(
              ValidateObjectsInUserDto.builder()
                  .name(rest.getTypeName())
                  .age(rest.getTypeValue())
                  .build());
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    for (Integer z = 0; z < rest.getAddress().size(); z++) {
      try {

        _backendResponse =
            allExternalCodesEcService.executeEmptyExternal(rest.getAddress().get(z).getNum());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {

        }

      } catch (Exception e) {
        throw new CadException("ERR-COMP-001", e.getCause());
      }
    }
    if (rest.getTypeValue() < 10) {

    } else {
    }
    return BackendResponse.builder()
        .body(
            TestingTypesBcValidateTypesOkResponseResponseDto.builder()
                .typeName(rest.getTypeName())
                .typeValue(rest.getTypeValue())
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeDeleteAll() throws CadException {

    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeDeleteValidateTypes();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteValidateObjects();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteValidateList();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(new EmptyResponse())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
