package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.AddUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUserCRUDPathVariableRequestDto;
import com.dedalow.cad.micro.commons.dto.request.UpdateUserCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.AddUserCrudCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetAllUsersCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.UpdateUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.exception.ExceptionResponse;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.commons.services.ConfigService;
import com.dedalow.cad.micro.services.UserCRUDService;
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
@RequestMapping(value = "/UserCRUD")
@RequiredArgsConstructor
public class UserCRUDController {

  @Autowired private ConfigService configService;

  @Autowired private UserCRUDService userCRUDService;

  @RequestMapping(value = "/getUser/{id:.*}", method = RequestMethod.GET)
  public ResponseEntity<?> getUser(GetUserCRUDPathVariableRequestDto pathRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(pathRequest.getId())) {
        errorParams.add("id");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = pathRequest.getId();

      GetUserCRUDOkResponseResponseDto response =
          GetUserCRUDOkResponseResponseDto.builder()
              .outputDomainEntity(userCRUDService.executeGetUser(id))
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

  @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
  public ResponseEntity<?> updateUser(@RequestBody UpdateUserCRUDBodyRequestDto bodyRequest) {

    try {
      List<String> errorParams = new ArrayList<String>();
      if (Objects.isNull(bodyRequest.getId())) {
        errorParams.add("id");
      }
      if (Objects.isNull(bodyRequest.getInputDomain())) {
        errorParams.add("inputDomain");
      }
      if (!errorParams.isEmpty()) {
        throw new CadException(
            "Params "
                + StringUtils.collectionToDelimitedString(errorParams, ", ")
                + " are required");
      }
      Long id = bodyRequest.getId();

      User inputDomain = bodyRequest.getInputDomain();

      UpdateUserCRUDOkResponseResponseDto response =
          UpdateUserCRUDOkResponseResponseDto.builder()
              .outputDomainEntity(userCRUDService.executeUpdateUser(id, inputDomain))
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

  @RequestMapping(value = "/addUserCrud", method = RequestMethod.POST)
  public ResponseEntity<?> addUserCrud(@RequestBody AddUserCrudCRUDBodyRequestDto bodyRequest) {

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

      User inputDomain = bodyRequest.getInputDomain();

      AddUserCrudCRUDOkResponseResponseDto response =
          AddUserCrudCRUDOkResponseResponseDto.builder()
              .outputDomainEntity(userCRUDService.executeAddUserCrud(inputDomain))
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

  @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
  public ResponseEntity<?> getAllUsers() {

    try {

      GetAllUsersCRUDOkResponseResponseDto response =
          GetAllUsersCRUDOkResponseResponseDto.builder()
              .outputDomainEntityList(userCRUDService.executeGetAllUsers())
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

  @RequestMapping(value = "/deleteUserCrud", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteUserCrud(
      @RequestBody DeleteUserCrudCRUDBodyRequestDto bodyRequest) {

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

      userCRUDService.executeDeleteUserCrud(id);

      return new ResponseEntity(HttpStatus.OK);
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
