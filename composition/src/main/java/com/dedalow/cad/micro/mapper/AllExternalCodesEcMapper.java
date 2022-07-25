package com.dedalow.cad.micro.mapper;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcAddGenerosBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcEmptyExternalBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcRollbackChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcSumatorioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcTestExternalCodeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcValidateTypesBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.proxy.AllExternalCodesEcProxy;
import feign.FeignException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AllExternalCodesEcMapper {

  @Autowired AllExternalCodesEcProxy allExternalCodesEcProxy;

  public BackendResponse<?> executeValidateTypes(
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

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.validateTypes(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeEmptyExternal(Integer typeValue) throws CadException {

    AllExternalCodesEcEmptyExternalBodyRequestDto bodyInput =
        AllExternalCodesEcEmptyExternalBodyRequestDto.builder().typeValue(typeValue).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.emptyExternal(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeTestExternalCode(String username) throws CadException {

    AllExternalCodesEcTestExternalCodeBodyRequestDto bodyInput =
        AllExternalCodesEcTestExternalCodeBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.testExternalCode(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeChangeVar(Integer var) throws CadException {

    AllExternalCodesEcChangeVarBodyRequestDto bodyInput =
        AllExternalCodesEcChangeVarBodyRequestDto.builder().var(var).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.changeVar(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeRollbackChangeVar(Integer var) throws CadException {

    AllExternalCodesEcRollbackChangeVarBodyRequestDto bodyInput =
        AllExternalCodesEcRollbackChangeVarBodyRequestDto.builder().var(var).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.rollbackChangeVar(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeAddGeneros(
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

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.addGeneros(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeSumatorio(Integer sumatorio, Integer iterate)
      throws CadException {

    AllExternalCodesEcSumatorioBodyRequestDto bodyInput =
        AllExternalCodesEcSumatorioBodyRequestDto.builder()
            .sumatorio(sumatorio)
            .iterate(iterate)
            .build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.sumatorio(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeChangeValue() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = allExternalCodesEcProxy.changeValue();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }
}
