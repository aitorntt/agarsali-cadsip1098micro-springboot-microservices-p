package com.dedalow.cad.micro.mapper;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosOutGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcAddGenerosBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcEmptyExternalBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcRollbackChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcSumatorioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcTestExternalCodeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcValidateTypesBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcAddGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcChangeValueOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcSumatorioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcTestExternalCodeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.proxy.AllExternalCodesEcProxy;
import com.fasterxml.jackson.core.type.TypeReference;
import feign.FeignException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AllExternalCodesEcMapper {

  @Autowired AllExternalCodesEcProxy allExternalCodesEcProxy;

  public String executeTestExternalCode(String username) throws CadException {

    AllExternalCodesEcTestExternalCodeBodyRequestDto bodyInput =
        AllExternalCodesEcTestExternalCodeBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = allExternalCodesEcProxy.testExternalCode(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<AllExternalCodesEcTestExternalCodeOkResponseResponseDto>() {})
          .getUsername();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeChangeVar(Integer var) throws CadException {

    AllExternalCodesEcChangeVarBodyRequestDto bodyInput =
        AllExternalCodesEcChangeVarBodyRequestDto.builder().var(var).build();

    try {
      allExternalCodesEcProxy.changeVar(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeRollbackChangeVar(Integer var) throws CadException {

    AllExternalCodesEcRollbackChangeVarBodyRequestDto bodyInput =
        AllExternalCodesEcRollbackChangeVarBodyRequestDto.builder().var(var).build();

    try {
      allExternalCodesEcProxy.rollbackChangeVar(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public List<AllExternalCodesEcAddGenerosOutGenerosDataDto> executeAddGeneros(
      List<AllExternalCodesEcAddGenerosInPeliculasDataDto> peliculas,
      BigDecimal valoracionMedia,
      List<AllExternalCodesEcAddGenerosInGenerosDataDto> generos,
      String genero)
      throws CadException {

    AllExternalCodesEcAddGenerosBodyRequestDto bodyInput =
        AllExternalCodesEcAddGenerosBodyRequestDto.builder()
            .peliculas(peliculas)
            .valoracionMedia(valoracionMedia)
            .generos(generos)
            .genero(genero)
            .build();

    try {
      ResponseEntity<?> response = allExternalCodesEcProxy.addGeneros(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<AllExternalCodesEcAddGenerosOkResponseResponseDto>() {})
          .getGeneros();
    } catch (FeignException e) {
      throw e;
    }
  }

  public Integer executeSumatorio(Integer sumatorio, Integer iterate) throws CadException {

    AllExternalCodesEcSumatorioBodyRequestDto bodyInput =
        AllExternalCodesEcSumatorioBodyRequestDto.builder()
            .sumatorio(sumatorio)
            .iterate(iterate)
            .build();

    try {
      ResponseEntity<?> response = allExternalCodesEcProxy.sumatorio(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<AllExternalCodesEcSumatorioOkResponseResponseDto>() {})
          .getSumatorio();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<AllExternalCodesEcValidateTypesInTypeListDataDto> typeList,
      Long typeLong,
      String typeLongText,
      AllExternalCodesEcValidateTypesInTypeObjectDto typeObject,
      String typePassword,
      String typeString)
      throws CadException {

    AllExternalCodesEcValidateTypesBodyRequestDto bodyInput =
        AllExternalCodesEcValidateTypesBodyRequestDto.builder()
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

    try {
      allExternalCodesEcProxy.validateTypes(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeEmptyExternal(Integer typeValue) throws CadException {

    AllExternalCodesEcEmptyExternalBodyRequestDto bodyInput =
        AllExternalCodesEcEmptyExternalBodyRequestDto.builder().typeValue(typeValue).build();

    try {
      allExternalCodesEcProxy.emptyExternal(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public Integer executeChangeValue() throws CadException {

    try {
      ResponseEntity<?> response = allExternalCodesEcProxy.changeValue();

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<AllExternalCodesEcChangeValueOkResponseResponseDto>() {})
          .getValue();
    } catch (FeignException e) {
      throw e;
    }
  }
}
