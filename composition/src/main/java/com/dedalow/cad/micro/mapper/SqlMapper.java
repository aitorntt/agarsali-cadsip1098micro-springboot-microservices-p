package com.dedalow.cad.micro.mapper;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetIdByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasAllOutPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMayor18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMayor18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5Hasta18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUserByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import com.dedalow.cad.micro.commons.dto.request.AddValidNameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUsuarioTransByNameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ForceFailBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetIdByUsernameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasAllBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMayor18BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMenor5BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMenor5Hasta18BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetTypeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUserByUsernameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUsuarioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUsuarioTransBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.InsertUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.SavePriceBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ShowProductsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateListBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateObjectsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateTypesBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.ForceFailOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetIdByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasAllOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTypeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ShowProductsOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.proxy.SqlProxy;
import com.fasterxml.jackson.core.type.TypeReference;
import feign.FeignException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SqlMapper {

  @Autowired SqlProxy sqlProxy;

  public void executeInsertUsuarioTest() throws CadException {

    try {
      sqlProxy.insertUsuarioTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertTitulosTest() throws CadException {

    try {
      sqlProxy.insertTitulosTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertGeneroTest() throws CadException {

    try {
      sqlProxy.insertGeneroTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertProductTest() throws CadException {

    try {
      sqlProxy.insertProductTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertTypeProductTest() throws CadException {

    try {
      sqlProxy.insertTypeProductTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertUsuarioTransTest() throws CadException {

    try {
      sqlProxy.insertUsuarioTransTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public GetUserByUsernameOutOutputSQLResultDto executeGetUserByUsername(String username)
      throws CadException {

    GetUserByUsernameBodyRequestDto bodyInput =
        GetUserByUsernameBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = sqlProxy.getUserByUsername(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetUserByUsernameOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public GetIdByUsernameOutOutputSQLResultDto executeGetIdByUsername(String username)
      throws CadException {

    GetIdByUsernameBodyRequestDto bodyInput =
        GetIdByUsernameBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = sqlProxy.getIdByUsername(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetIdByUsernameOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertUser(String username) throws CadException {

    InsertUserBodyRequestDto bodyInput =
        InsertUserBodyRequestDto.builder().username(username).build();

    try {
      sqlProxy.insertUser(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public List<ForceFailOutOutputSQLResultDataDto> executeForceFail(String username)
      throws CadException {

    ForceFailBodyRequestDto bodyInput =
        ForceFailBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = sqlProxy.forceFail(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<ForceFailOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public GetUsuarioTransOutOutputSQLResultDto executeGetUsuarioTrans(String username)
      throws CadException {

    GetUsuarioTransBodyRequestDto bodyInput =
        GetUsuarioTransBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = sqlProxy.getUsuarioTrans(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetUsuarioTransOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeSavePrice(BigDecimal price, String currency, Long productId)
      throws CadException {

    SavePriceBodyRequestDto bodyInput =
        SavePriceBodyRequestDto.builder()
            .price(price)
            .currency(currency)
            .productId(productId)
            .build();

    try {
      sqlProxy.savePrice(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public GetTypeOutTypeDto executeGetType(Long typeId) throws CadException {

    GetTypeBodyRequestDto bodyInput = GetTypeBodyRequestDto.builder().typeId(typeId).build();

    try {
      ResponseEntity<?> response = sqlProxy.getType(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetTypeOkResponseResponseDto>() {})
          .getType();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<ShowProductsOutProductsDataDto> executeShowProducts(Long typeId) throws CadException {

    ShowProductsBodyRequestDto bodyInput =
        ShowProductsBodyRequestDto.builder().typeId(typeId).build();

    try {
      ResponseEntity<?> response = sqlProxy.showProducts(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<ShowProductsOkResponseResponseDto>() {})
          .getProducts();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUser(String username) throws CadException {

    DeleteUserBodyRequestDto bodyInput =
        DeleteUserBodyRequestDto.builder().username(username).build();

    try {
      sqlProxy.deleteUser(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUsuarioTransByName(String username) throws CadException {

    DeleteUsuarioTransByNameBodyRequestDto bodyInput =
        DeleteUsuarioTransByNameBodyRequestDto.builder().username(username).build();

    try {
      sqlProxy.deleteUsuarioTransByName(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public GetUsuarioOutOutputSQLResultDto executeGetUsuario(String username) throws CadException {

    GetUsuarioBodyRequestDto bodyInput =
        GetUsuarioBodyRequestDto.builder().username(username).build();

    try {
      ResponseEntity<?> response = sqlProxy.getUsuario(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetUsuarioOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetGenerosOutOutputSQLResultDataDto> executeGetGeneros() throws CadException {

    try {
      ResponseEntity<?> response = sqlProxy.getGeneros();

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetGenerosOkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetPeliculasMenor5OutOutputSQLResultDataDto> executeGetPeliculasMenor5(Long generoId)
      throws CadException {

    GetPeliculasMenor5BodyRequestDto bodyInput =
        GetPeliculasMenor5BodyRequestDto.builder().generoId(generoId).build();

    try {
      ResponseEntity<?> response = sqlProxy.getPeliculasMenor5(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetPeliculasMenor5OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> executeGetPeliculasMenor5Hasta18(
      Long generoId) throws CadException {

    GetPeliculasMenor5Hasta18BodyRequestDto bodyInput =
        GetPeliculasMenor5Hasta18BodyRequestDto.builder().generoId(generoId).build();

    try {
      ResponseEntity<?> response = sqlProxy.getPeliculasMenor5Hasta18(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<GetPeliculasMenor5Hasta18OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetPeliculasMayor18OutOutputSQLResultDataDto> executeGetPeliculasMayor18(
      Long generoId) throws CadException {

    GetPeliculasMayor18BodyRequestDto bodyInput =
        GetPeliculasMayor18BodyRequestDto.builder().generoId(generoId).build();

    try {
      ResponseEntity<?> response = sqlProxy.getPeliculasMayor18(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetPeliculasMayor18OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetPeliculasAllOutPeliculasAllDataDto> executeGetPeliculasAll(Long generoId)
      throws CadException {

    GetPeliculasAllBodyRequestDto bodyInput =
        GetPeliculasAllBodyRequestDto.builder().generoId(generoId).build();

    try {
      ResponseEntity<?> response = sqlProxy.getPeliculasAll(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetPeliculasAllOkResponseResponseDto>() {})
          .getPeliculasAll();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetSeriesMenor5OutOutputSQLResultDataDto> executeGetSeriesMenor5()
      throws CadException {

    try {
      ResponseEntity<?> response = sqlProxy.getSeriesMenor5();

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetSeriesMenor5OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetSeriesMenor5Hasta18OutOutputSQLResultDataDto> executeGetSeriesMenor5Hasta18()
      throws CadException {

    try {
      ResponseEntity<?> response = sqlProxy.getSeriesMenor5Hasta18();

      return ObjectMapperUtil.convertValue(
              response.getBody(),
              new TypeReference<GetSeriesMenor5Hasta18OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<GetSeriesMayor18OutOutputSQLResultDataDto> executeGetSeriesMayor18()
      throws CadException {

    try {
      ResponseEntity<?> response = sqlProxy.getSeriesMayor18();

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetSeriesMayor18OkResponseResponseDto>() {})
          .getOutputSQLResult();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString)
      throws CadException {

    ValidateTypesBodyRequestDto bodyInput =
        ValidateTypesBodyRequestDto.builder()
            .typeBoolean(typeBoolean)
            .typeDecimal(typeDecimal)
            .typeInteger(typeInteger)
            .typeLong(typeLong)
            .typeLongText(typeLongText)
            .typePassword(typePassword)
            .typeString(typeString)
            .build();

    try {
      sqlProxy.validateTypes(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeValidateObjects(ValidateObjectsInUserDto user) throws CadException {

    ValidateObjectsBodyRequestDto bodyInput =
        ValidateObjectsBodyRequestDto.builder().user(user).build();

    try {
      sqlProxy.validateObjects(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeValidateList(Integer price) throws CadException {

    ValidateListBodyRequestDto bodyInput =
        ValidateListBodyRequestDto.builder().price(price).build();

    try {
      sqlProxy.validateList(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteValidateTypes() throws CadException {

    try {
      sqlProxy.deleteValidateTypes();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteValidateObjects() throws CadException {

    try {
      sqlProxy.deleteValidateObjects();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteValidateList() throws CadException {

    try {
      sqlProxy.deleteValidateList();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeAddValidName(String name) throws CadException {

    AddValidNameBodyRequestDto bodyInput = AddValidNameBodyRequestDto.builder().name(name).build();

    try {
      sqlProxy.addValidName(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUserTest() throws CadException {

    try {
      sqlProxy.deleteUserTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUsuarioTest() throws CadException {

    try {
      sqlProxy.deleteUsuarioTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteTitulosTest() throws CadException {

    try {
      sqlProxy.deleteTitulosTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteGeneroTest() throws CadException {

    try {
      sqlProxy.deleteGeneroTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteProductTest() throws CadException {

    try {
      sqlProxy.deleteProductTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteTypeProductTest() throws CadException {

    try {
      sqlProxy.deleteTypeProductTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUsuarioTransTest() throws CadException {

    try {
      sqlProxy.deleteUsuarioTransTest();

    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeInsertUsertTest() throws CadException {

    try {
      sqlProxy.insertUsertTest();

    } catch (FeignException e) {
      throw e;
    }
  }
}
