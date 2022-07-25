package com.dedalow.cad.micro.mapper;

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
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.proxy.SqlProxy;
import feign.FeignException;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SqlMapper {

  @Autowired SqlProxy sqlProxy;

  public BackendResponse<?> executeInsertUsuarioTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertUsuarioTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertTitulosTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertTitulosTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertGeneroTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertGeneroTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertProductTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertProductTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertTypeProductTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertTypeProductTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertUsuarioTransTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertUsuarioTransTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetUserByUsername(String username) throws CadException {

    GetUserByUsernameBodyRequestDto bodyInput =
        GetUserByUsernameBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getUserByUsername(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetIdByUsername(String username) throws CadException {

    GetIdByUsernameBodyRequestDto bodyInput =
        GetIdByUsernameBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getIdByUsername(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertUser(String username) throws CadException {

    InsertUserBodyRequestDto bodyInput =
        InsertUserBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertUser(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeForceFail(String username) throws CadException {

    ForceFailBodyRequestDto bodyInput =
        ForceFailBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.forceFail(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetUsuarioTrans(String username) throws CadException {

    GetUsuarioTransBodyRequestDto bodyInput =
        GetUsuarioTransBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getUsuarioTrans(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeSavePrice(BigDecimal price, String currency, Long productId)
      throws CadException {

    SavePriceBodyRequestDto bodyInput =
        SavePriceBodyRequestDto.builder()
            .price(price)
            .currency(currency)
            .productId(productId)
            .build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.savePrice(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetType(Long typeId) throws CadException {

    GetTypeBodyRequestDto bodyInput = GetTypeBodyRequestDto.builder().typeId(typeId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getType(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeShowProducts(Long typeId) throws CadException {

    ShowProductsBodyRequestDto bodyInput =
        ShowProductsBodyRequestDto.builder().typeId(typeId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.showProducts(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUser(String username) throws CadException {

    DeleteUserBodyRequestDto bodyInput =
        DeleteUserBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteUser(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUsuarioTransByName(String username) throws CadException {

    DeleteUsuarioTransByNameBodyRequestDto bodyInput =
        DeleteUsuarioTransByNameBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteUsuarioTransByName(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetUsuario(String username) throws CadException {

    GetUsuarioBodyRequestDto bodyInput =
        GetUsuarioBodyRequestDto.builder().username(username).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getUsuario(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetGeneros() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getGeneros();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetPeliculasMenor5(Long generoId) throws CadException {

    GetPeliculasMenor5BodyRequestDto bodyInput =
        GetPeliculasMenor5BodyRequestDto.builder().generoId(generoId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getPeliculasMenor5(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetPeliculasMenor5Hasta18(Long generoId) throws CadException {

    GetPeliculasMenor5Hasta18BodyRequestDto bodyInput =
        GetPeliculasMenor5Hasta18BodyRequestDto.builder().generoId(generoId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getPeliculasMenor5Hasta18(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetPeliculasMayor18(Long generoId) throws CadException {

    GetPeliculasMayor18BodyRequestDto bodyInput =
        GetPeliculasMayor18BodyRequestDto.builder().generoId(generoId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getPeliculasMayor18(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetPeliculasAll(Long generoId) throws CadException {

    GetPeliculasAllBodyRequestDto bodyInput =
        GetPeliculasAllBodyRequestDto.builder().generoId(generoId).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getPeliculasAll(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetSeriesMenor5() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getSeriesMenor5();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetSeriesMenor5Hasta18() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getSeriesMenor5Hasta18();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetSeriesMayor18() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.getSeriesMayor18();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeValidateTypes(
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

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.validateTypes(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeValidateObjects(ValidateObjectsInUserDto user)
      throws CadException {

    ValidateObjectsBodyRequestDto bodyInput =
        ValidateObjectsBodyRequestDto.builder().user(user).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.validateObjects(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeValidateList(Integer price) throws CadException {

    ValidateListBodyRequestDto bodyInput =
        ValidateListBodyRequestDto.builder().price(price).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.validateList(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteValidateTypes() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteValidateTypes();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteValidateObjects() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteValidateObjects();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteValidateList() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteValidateList();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeAddValidName(String name) throws CadException {

    AddValidNameBodyRequestDto bodyInput = AddValidNameBodyRequestDto.builder().name(name).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.addValidName(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUserTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteUserTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUsuarioTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteUsuarioTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteTitulosTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteTitulosTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteGeneroTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteGeneroTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteProductTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteProductTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteTypeProductTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteTypeProductTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUsuarioTransTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.deleteUsuarioTransTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeInsertUsertTest() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = sqlProxy.insertUsertTest();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }
}
