package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import com.dedalow.cad.micro.commons.dto.request.AddTituloBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AddTypeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AddUsuarioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AddUsuarioTransBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AddValidNameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteProductBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteTituloBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteTypeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUsuarioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUsuarioTransBodyRequestDto;
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
import com.dedalow.cad.micro.commons.dto.response.GetListUsuariosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasAllOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTitulosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTypeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTypesOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuariosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuariosTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ShowProductsOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.SqlService;
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
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class SqlController {

  @Autowired private ConfigService configService;

  @Autowired private SqlService sqlService;

  @RequestMapping(value = "/delete-usuario-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTest() {

    try {

      sqlService.executeDeleteUsuarioTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-peliculas-menor5-hasta18", method = RequestMethod.POST)
  public ResponseEntity<?> getPeliculasMenor5Hasta18(
      @RequestBody GetPeliculasMenor5Hasta18BodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getGeneroId())) {
        errorParams.add("generoId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long generoId = bodyRequest.getGeneroId();

      GetPeliculasMenor5Hasta18OkResponseResponseDto response =
          GetPeliculasMenor5Hasta18OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetPeliculasMenor5Hasta18(generoId))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/force-fail", method = RequestMethod.POST)
  public ResponseEntity<?> forceFail(@RequestBody ForceFailBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      ForceFailOkResponseResponseDto response =
          ForceFailOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeForceFail(username))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/validate-list", method = RequestMethod.POST)
  public ResponseEntity<?> validateList(@RequestBody ValidateListBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getPrice())) {
        errorParams.add("price");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer price = bodyRequest.getPrice();

      sqlService.executeValidateList(price);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/validate-types", method = RequestMethod.POST)
  public ResponseEntity<?> validateTypes(@RequestBody ValidateTypesBodyRequestDto bodyRequest) {

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
      if (Objects.isNull(bodyRequest.getTypeLong())) {
        errorParams.add("typeLong");
      }
      if (Objects.isNull(bodyRequest.getTypeLongText())) {
        errorParams.add("typeLongText");
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
      Long typeLong = bodyRequest.getTypeLong();
      String typeLongText = bodyRequest.getTypeLongText();
      String typePassword = bodyRequest.getTypePassword();
      String typeString = bodyRequest.getTypeString();

      sqlService.executeValidateTypes(
          typeBoolean, typeDecimal, typeInteger, typeLong, typeLongText, typePassword, typeString);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-usuarios-trans", method = RequestMethod.POST)
  public ResponseEntity<?> getUsuariosTrans() {

    try {

      GetUsuariosTransOkResponseResponseDto response =
          GetUsuariosTransOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetUsuariosTrans())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertProductTest() {

    try {

      sqlService.executeInsertProductTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-user-by-username", method = RequestMethod.POST)
  public ResponseEntity<?> getUserByUsername(
      @RequestBody GetUserByUsernameBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      GetUserByUsernameOkResponseResponseDto response =
          GetUserByUsernameOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetUserByUsername(username))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-genero-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertGeneroTest() {

    try {

      sqlService.executeInsertGeneroTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-user", method = RequestMethod.POST)
  public ResponseEntity<?> insertUser(@RequestBody InsertUserBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      sqlService.executeInsertUser(username);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUser(@RequestBody DeleteUserBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      sqlService.executeDeleteUser(username);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-id-by-username", method = RequestMethod.POST)
  public ResponseEntity<?> getIdByUsername(@RequestBody GetIdByUsernameBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      GetIdByUsernameOkResponseResponseDto response =
          GetIdByUsernameOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetIdByUsername(username))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-usuario", method = RequestMethod.POST)
  public ResponseEntity<?> getUsuario(@RequestBody GetUsuarioBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      GetUsuarioOkResponseResponseDto response =
          GetUsuarioOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetUsuario(username))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-peliculas-all", method = RequestMethod.POST)
  public ResponseEntity<?> getPeliculasAll(@RequestBody GetPeliculasAllBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getGeneroId())) {
        errorParams.add("generoId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long generoId = bodyRequest.getGeneroId();

      GetPeliculasAllOkResponseResponseDto response =
          GetPeliculasAllOkResponseResponseDto.builder()
              .peliculasAll(sqlService.executeGetPeliculasAll(generoId))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-peliculas-menor5", method = RequestMethod.POST)
  public ResponseEntity<?> getPeliculasMenor5(
      @RequestBody GetPeliculasMenor5BodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getGeneroId())) {
        errorParams.add("generoId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long generoId = bodyRequest.getGeneroId();

      GetPeliculasMenor5OkResponseResponseDto response =
          GetPeliculasMenor5OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetPeliculasMenor5(generoId))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-peliculas-mayor18", method = RequestMethod.POST)
  public ResponseEntity<?> getPeliculasMayor18(
      @RequestBody GetPeliculasMayor18BodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getGeneroId())) {
        errorParams.add("generoId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long generoId = bodyRequest.getGeneroId();

      GetPeliculasMayor18OkResponseResponseDto response =
          GetPeliculasMayor18OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetPeliculasMayor18(generoId))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-series-menor5", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMenor5() {

    try {

      GetSeriesMenor5OkResponseResponseDto response =
          GetSeriesMenor5OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetSeriesMenor5())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-series-menor5-hasta18", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMenor5Hasta18() {

    try {

      GetSeriesMenor5Hasta18OkResponseResponseDto response =
          GetSeriesMenor5Hasta18OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetSeriesMenor5Hasta18())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-series-mayor18", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMayor18() {

    try {

      GetSeriesMayor18OkResponseResponseDto response =
          GetSeriesMayor18OkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetSeriesMayor18())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/add-usuario", method = RequestMethod.POST)
  public ResponseEntity<?> addUsuario(@RequestBody AddUsuarioBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getNombre())) {
        errorParams.add("nombre");
      }
      if (Objects.isNull(bodyRequest.getApellidos())) {
        errorParams.add("apellidos");
      }
      if (Objects.isNull(bodyRequest.getEdad())) {
        errorParams.add("edad");
      }
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String nombre = bodyRequest.getNombre();
      String apellidos = bodyRequest.getApellidos();
      Integer edad = bodyRequest.getEdad();
      String username = bodyRequest.getUsername();

      sqlService.executeAddUsuario(nombre, apellidos, edad, username);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/add-titulo", method = RequestMethod.POST)
  public ResponseEntity<?> addTitulo(@RequestBody AddTituloBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getAdult())) {
        errorParams.add("adult");
      }
      if (Objects.isNull(bodyRequest.getValoracion())) {
        errorParams.add("valoracion");
      }
      if (Objects.isNull(bodyRequest.getBaby())) {
        errorParams.add("baby");
      }
      if (Objects.isNull(bodyRequest.getPelicula())) {
        errorParams.add("pelicula");
      }
      if (Objects.isNull(bodyRequest.getMedium())) {
        errorParams.add("medium");
      }
      if (Objects.isNull(bodyRequest.getTitulo())) {
        errorParams.add("titulo");
      }
      if (Objects.isNull(bodyRequest.getGeneroId())) {
        errorParams.add("generoId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer adult = bodyRequest.getAdult();
      Integer valoracion = bodyRequest.getValoracion();
      Integer baby = bodyRequest.getBaby();
      Integer pelicula = bodyRequest.getPelicula();
      Integer medium = bodyRequest.getMedium();
      String titulo = bodyRequest.getTitulo();
      Long generoId = bodyRequest.getGeneroId();

      sqlService.executeAddTitulo(adult, valoracion, baby, pelicula, medium, titulo, generoId);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-titulos", method = RequestMethod.POST)
  public ResponseEntity<?> getTitulos() {

    try {

      GetTitulosOkResponseResponseDto response =
          GetTitulosOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetTitulos())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-usuarios", method = RequestMethod.POST)
  public ResponseEntity<?> getUsuarios() {

    try {

      GetUsuariosOkResponseResponseDto response =
          GetUsuariosOkResponseResponseDto.builder()
              .usuarios(sqlService.executeGetUsuarios())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-usuario-trans", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTrans(
      @RequestBody DeleteUsuarioTransBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      sqlService.executeDeleteUsuarioTrans(id);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/add-usuario-trans", method = RequestMethod.POST)
  public ResponseEntity<?> addUsuarioTrans(@RequestBody AddUsuarioTransBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      sqlService.executeAddUsuarioTrans(username);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-usuario-trans", method = RequestMethod.POST)
  public ResponseEntity<?> getUsuarioTrans(@RequestBody GetUsuarioTransBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      GetUsuarioTransOkResponseResponseDto response =
          GetUsuarioTransOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetUsuarioTrans(username))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/save-price", method = RequestMethod.POST)
  public ResponseEntity<?> savePrice(@RequestBody SavePriceBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getPrice())) {
        errorParams.add("price");
      }
      if (Objects.isNull(bodyRequest.getCurrency())) {
        errorParams.add("currency");
      }
      if (Objects.isNull(bodyRequest.getProductId())) {
        errorParams.add("productId");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      BigDecimal price = bodyRequest.getPrice();
      String currency = bodyRequest.getCurrency();
      Long productId = bodyRequest.getProductId();

      sqlService.executeSavePrice(price, currency, productId);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/show-products", method = RequestMethod.POST)
  public ResponseEntity<?> showProducts(@RequestBody ShowProductsBodyRequestDto bodyRequest) {

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

      ShowProductsOkResponseResponseDto response =
          ShowProductsOkResponseResponseDto.builder()
              .products(sqlService.executeShowProducts(typeId))
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-generos", method = RequestMethod.POST)
  public ResponseEntity<?> getGeneros() {

    try {

      GetGenerosOkResponseResponseDto response =
          GetGenerosOkResponseResponseDto.builder()
              .outputSQLResult(sqlService.executeGetGeneros())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-usuario", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuario(@RequestBody DeleteUsuarioBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      sqlService.executeDeleteUsuario(id);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-titulo", method = RequestMethod.POST)
  public ResponseEntity<?> deleteTitulo(@RequestBody DeleteTituloBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      sqlService.executeDeleteTitulo(id);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-product", method = RequestMethod.POST)
  public ResponseEntity<?> deleteProduct(@RequestBody DeleteProductBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      sqlService.executeDeleteProduct(id);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-types", method = RequestMethod.POST)
  public ResponseEntity<?> getTypes() {

    try {

      GetTypesOkResponseResponseDto response =
          GetTypesOkResponseResponseDto.builder().types(sqlService.executeGetTypes()).build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/add-type", method = RequestMethod.POST)
  public ResponseEntity<?> addType(@RequestBody AddTypeBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getName())) {
        errorParams.add("name");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String name = bodyRequest.getName();

      sqlService.executeAddType(name);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-type", method = RequestMethod.POST)
  public ResponseEntity<?> getType(@RequestBody GetTypeBodyRequestDto bodyRequest) {

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

      GetTypeOkResponseResponseDto response =
          GetTypeOkResponseResponseDto.builder().type(sqlService.executeGetType(typeId)).build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/validate-objects", method = RequestMethod.POST)
  public ResponseEntity<?> validateObjects(@RequestBody ValidateObjectsBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUser())) {
        errorParams.add("user");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }

      ValidateObjectsInUserDto user = bodyRequest.getUser();

      sqlService.executeValidateObjects(user);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-validate-types", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateTypes() {

    try {

      sqlService.executeDeleteValidateTypes();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-validate-objects", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateObjects() {

    try {

      sqlService.executeDeleteValidateObjects();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-validate-list", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateList() {

    try {

      sqlService.executeDeleteValidateList();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-type", method = RequestMethod.POST)
  public ResponseEntity<?> deleteType(@RequestBody DeleteTypeBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      sqlService.executeDeleteType(id);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-usuario-trans-by-name", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTransByName(
      @RequestBody DeleteUsuarioTransByNameBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getUsername())) {
        errorParams.add("username");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String username = bodyRequest.getUsername();

      sqlService.executeDeleteUsuarioTransByName(username);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/add-valid-name", method = RequestMethod.POST)
  public ResponseEntity<?> addValidName(@RequestBody AddValidNameBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getName())) {
        errorParams.add("name");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String name = bodyRequest.getName();

      sqlService.executeAddValidName(name);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-names", method = RequestMethod.POST)
  public ResponseEntity<?> deleteNames() {

    try {

      sqlService.executeDeleteNames();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/get-list-usuarios", method = RequestMethod.POST)
  public ResponseEntity<?> getListUsuarios() {

    try {

      GetListUsuariosOkResponseResponseDto response =
          GetListUsuariosOkResponseResponseDto.builder()
              .usuarios(sqlService.executeGetListUsuarios())
              .build();

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-type-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertTypeProductTest() {

    try {

      sqlService.executeInsertTypeProductTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-genero-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteGeneroTest() {

    try {

      sqlService.executeDeleteGeneroTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-type-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteTypeProductTest() {

    try {

      sqlService.executeDeleteTypeProductTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-titulos-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteTitulosTest() {

    try {

      sqlService.executeDeleteTitulosTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteProductTest() {

    try {

      sqlService.executeDeleteProductTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-user-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUserTest() {

    try {

      sqlService.executeDeleteUserTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/delete-usuario-trans-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTransTest() {

    try {

      sqlService.executeDeleteUsuarioTransTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-usuario-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsuarioTest() {

    try {

      sqlService.executeInsertUsuarioTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-usert-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsertTest() {

    try {

      sqlService.executeInsertUsertTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-usuario-trans-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsuarioTransTest() {

    try {

      sqlService.executeInsertUsuarioTransTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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

  @RequestMapping(value = "/insert-titulos-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertTitulosTest() {

    try {

      sqlService.executeInsertTitulosTest();

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "SQL");
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
