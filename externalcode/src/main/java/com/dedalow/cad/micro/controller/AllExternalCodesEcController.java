package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcAddGenerosBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcCastDecimalBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcCastIntegerBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcCastLongBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcCastStringBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcEmptyExternalBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcJoinPeliculasBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcRollbackChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcSumaValoracionBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcSumatorioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcTestExternalCodeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcValidateTypesBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcValoracionMediaBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.AllExternalCodesEcService;
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
@RequestMapping(value = "/all-external-codes_ec")
@RequiredArgsConstructor
public class AllExternalCodesEcController {

  @Autowired private ConfigService configService;

  @Autowired private AllExternalCodesEcService allexternalcodesEcService;

  @RequestMapping(value = "/add-generos", method = RequestMethod.POST)
  public ResponseEntity<?> addGeneros(
      @RequestBody AllExternalCodesEcAddGenerosBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getPeliculas())) {
        errorParams.add("peliculas");
      }
      if (Objects.isNull(bodyRequest.getValoracionMedia())) {
        errorParams.add("valoracionMedia");
      }
      if (Objects.isNull(bodyRequest.getGeneros())) {
        errorParams.add("generos");
      }
      if (Objects.isNull(bodyRequest.getGenero())) {
        errorParams.add("genero");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      List<AllExternalCodesEcAddGenerosInPeliculasDataDto> peliculas = bodyRequest.getPeliculas();
      BigDecimal valoracionMedia = bodyRequest.getValoracionMedia();
      List<AllExternalCodesEcAddGenerosInGenerosDataDto> generos = bodyRequest.getGeneros();
      String genero = bodyRequest.getGenero();

      BackendResponse<?> response =
          allexternalcodesEcService.executeAddGeneros(peliculas, valoracionMedia, generos, genero);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/cast-decimal", method = RequestMethod.POST)
  public ResponseEntity<?> castDecimal(
      @RequestBody AllExternalCodesEcCastDecimalBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getInputValue())) {
        errorParams.add("inputValue");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      BigDecimal inputValue = bodyRequest.getInputValue();

      BackendResponse<?> response = allexternalcodesEcService.executeCastDecimal(inputValue);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/get-integer-value", method = RequestMethod.POST)
  public ResponseEntity<?> getIntegerValue() {

    try {

      BackendResponse<?> response = allexternalcodesEcService.executeGetIntegerValue();

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/test-external-code", method = RequestMethod.POST)
  public ResponseEntity<?> testExternalCode(
      @RequestBody AllExternalCodesEcTestExternalCodeBodyRequestDto bodyRequest) {

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

      BackendResponse<?> response = allexternalcodesEcService.executeTestExternalCode(username);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/sumatorio", method = RequestMethod.POST)
  public ResponseEntity<?> sumatorio(
      @RequestBody AllExternalCodesEcSumatorioBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getSumatorio())) {
        errorParams.add("sumatorio");
      }
      if (Objects.isNull(bodyRequest.getIterate())) {
        errorParams.add("iterate");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer sumatorio = bodyRequest.getSumatorio();
      Integer iterate = bodyRequest.getIterate();

      BackendResponse<?> response = allexternalcodesEcService.executeSumatorio(sumatorio, iterate);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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
  public ResponseEntity<?> validateTypes(
      @RequestBody AllExternalCodesEcValidateTypesBodyRequestDto bodyRequest) {

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
      if (Objects.isNull(bodyRequest.getTypeList())) {
        errorParams.add("typeList");
      }
      if (Objects.isNull(bodyRequest.getTypeLong())) {
        errorParams.add("typeLong");
      }
      if (Objects.isNull(bodyRequest.getTypeLongText())) {
        errorParams.add("typeLongText");
      }
      if (Objects.isNull(bodyRequest.getTypeObject())) {
        errorParams.add("typeObject");
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
      List<AllExternalCodesEcValidateTypesInTypeListDataDto> typeList = bodyRequest.getTypeList();
      Long typeLong = bodyRequest.getTypeLong();
      String typeLongText = bodyRequest.getTypeLongText();

      AllExternalCodesEcValidateTypesInTypeObjectDto typeObject = bodyRequest.getTypeObject();
      String typePassword = bodyRequest.getTypePassword();
      String typeString = bodyRequest.getTypeString();

      allexternalcodesEcService.executeValidateTypes(
          typeBoolean,
          typeDecimal,
          typeInteger,
          typeList,
          typeLong,
          typeLongText,
          typeObject,
          typePassword,
          typeString);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/change-value", method = RequestMethod.POST)
  public ResponseEntity<?> changeValue() {

    try {

      BackendResponse<?> response = allexternalcodesEcService.executeChangeValue();

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/change-var", method = RequestMethod.POST)
  public ResponseEntity<?> changeVar(
      @RequestBody AllExternalCodesEcChangeVarBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getVar())) {
        errorParams.add("var");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer var = bodyRequest.getVar();

      allexternalcodesEcService.executeChangeVar(var);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/cast-integer", method = RequestMethod.POST)
  public ResponseEntity<?> castInteger(
      @RequestBody AllExternalCodesEcCastIntegerBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getInputValue())) {
        errorParams.add("inputValue");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer inputValue = bodyRequest.getInputValue();

      BackendResponse<?> response = allexternalcodesEcService.executeCastInteger(inputValue);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/empty-external", method = RequestMethod.POST)
  public ResponseEntity<?> emptyExternal(
      @RequestBody AllExternalCodesEcEmptyExternalBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getTypeValue())) {
        errorParams.add("typeValue");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer typeValue = bodyRequest.getTypeValue();

      allexternalcodesEcService.executeEmptyExternal(typeValue);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/rollback-change-var", method = RequestMethod.POST)
  public ResponseEntity<?> rollbackChangeVar(
      @RequestBody AllExternalCodesEcRollbackChangeVarBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getVar())) {
        errorParams.add("var");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer var = bodyRequest.getVar();

      allexternalcodesEcService.executeRollbackChangeVar(var);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/join-peliculas", method = RequestMethod.POST)
  public ResponseEntity<?> joinPeliculas(
      @RequestBody AllExternalCodesEcJoinPeliculasBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getPeliculas())) {
        errorParams.add("peliculas");
      }
      if (Objects.isNull(bodyRequest.getPeliculasAll())) {
        errorParams.add("peliculasAll");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      List<AllExternalCodesEcJoinPeliculasInPeliculasDataDto> peliculas =
          bodyRequest.getPeliculas();
      List<AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto> peliculasAll =
          bodyRequest.getPeliculasAll();

      BackendResponse<?> response =
          allexternalcodesEcService.executeJoinPeliculas(peliculas, peliculasAll);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/cast-long", method = RequestMethod.POST)
  public ResponseEntity<?> castLong(
      @RequestBody AllExternalCodesEcCastLongBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getInputValue())) {
        errorParams.add("inputValue");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long inputValue = bodyRequest.getInputValue();

      BackendResponse<?> response = allexternalcodesEcService.executeCastLong(inputValue);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/lista-peliculas", method = RequestMethod.POST)
  public ResponseEntity<?> listaPeliculas() {

    try {

      BackendResponse<?> response = allexternalcodesEcService.executeListaPeliculas();

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/suma-valoracion", method = RequestMethod.POST)
  public ResponseEntity<?> sumaValoracion(
      @RequestBody AllExternalCodesEcSumaValoracionBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getValoracion())) {
        errorParams.add("valoracion");
      }
      if (Objects.isNull(bodyRequest.getValoracionElementos())) {
        errorParams.add("valoracionElementos");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer valoracion = bodyRequest.getValoracion();
      Integer valoracionElementos = bodyRequest.getValoracionElementos();

      BackendResponse<?> response =
          allexternalcodesEcService.executeSumaValoracion(valoracion, valoracionElementos);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/cast-string", method = RequestMethod.POST)
  public ResponseEntity<?> castString(
      @RequestBody AllExternalCodesEcCastStringBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getInputValue())) {
        errorParams.add("inputValue");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      String inputValue = bodyRequest.getInputValue();

      BackendResponse<?> response = allexternalcodesEcService.executeCastString(inputValue);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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

  @RequestMapping(value = "/valoracion-media", method = RequestMethod.POST)
  public ResponseEntity<?> valoracionMedia(
      @RequestBody AllExternalCodesEcValoracionMediaBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getValoracion())) {
        errorParams.add("valoracion");
      }
      if (Objects.isNull(bodyRequest.getElementos())) {
        errorParams.add("elementos");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Integer valoracion = bodyRequest.getValoracion();
      List<String> elementos = bodyRequest.getElementos();

      BackendResponse<?> response =
          allexternalcodesEcService.executeValoracionMedia(valoracion, elementos);

      return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    } catch (Exception e) {

      ExceptionResponse exceptionResponse = configService.selectedException(e, "EC");
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
