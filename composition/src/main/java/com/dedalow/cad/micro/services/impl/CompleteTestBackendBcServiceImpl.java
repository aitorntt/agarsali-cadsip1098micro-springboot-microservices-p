package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.CompleteTestBackendBcCompleteBackendExampleOutDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetIdByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUserByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.response.AddUserCrudCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcTestExternalCodeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.CompleteTestBackendBcAddUserOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.CompleteTestBackendBcCompleteBackendExampleOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.CompleteTestBackendBcCrudsOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.CompleteTestBackendBcCustomsAndRestOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetAllUsersCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetIdByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.SmartRiLoginOkResponseDto;
import com.dedalow.cad.micro.commons.dto.response.SmartRiUserDetailOkResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.UpdateUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SmartRiMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.mapper.UserCRUDMapper;
import com.dedalow.cad.micro.services.CompleteTestBackendBcService;
import com.dedalow.cad.micro.services.TestOtherCompositionBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteTestBackendBcServiceImpl implements CompleteTestBackendBcService {

  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired SqlMapper sqlService;
  @Autowired SmartRiMapper smartRiService;
  @Autowired TestOtherCompositionBcService testOtherCompositionBcService;
  @Autowired CompleteTestBackendBcService completeTestBackendBcService;
  @Autowired UserCRUDMapper userCRUDService;

  @Override
  public BackendResponse<?> executeCustomsAndRest(String username) throws CadException {

    String bc3 = "";

    GetUserByUsernameOutOutputSQLResultDto op1 = null;

    SmartRiLoginOkResponseDto op2 = null;

    SmartRiUserDetailOkResponseDto op3 = null;
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = allExternalCodesEcService.executeTestExternalCode(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        bc3 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<AllExternalCodesEcTestExternalCodeOkResponseResponseDto>() {})
                .getUsername();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeGetUserByUsername(bc3);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op1 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetUserByUsernameOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = smartRiService.executeLogin(op1.getUsername(), op1.getPassword());

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op2 =
            ObjectMapperUtil.convertValue(
                _backendResponse.getBody(), new TypeReference<SmartRiLoginOkResponseDto>() {});
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = smartRiService.executeUserDetail(op2.getToken(), op1.getUsername());

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op3 =
            ObjectMapperUtil.convertValue(
                _backendResponse.getBody(), new TypeReference<SmartRiUserDetailOkResponseDto>() {});
      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    return BackendResponse.builder()
        .body(
            CompleteTestBackendBcCustomsAndRestOkResponseResponseDto.builder()
                .username(op3.getUsername())
                .email(op3.getEmail())
                .name(op3.getName())
                .surnames(op3.getSurnames())
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeCompleteBackendExample(String username) throws CadException {

    String ca1 = null;
    String ca2 = null;

    GetIdByUsernameOutOutputSQLResultDto op1 = null;
    String op2 = null;

    CompleteTestBackendBcCustomsAndRestOkResponseResponseDto op3 = null;
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = testOtherCompositionBcService.executeTestOtherComposition(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        ca1 =
            ObjectMapperUtil.convertValue(
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<
                            TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto>() {})
                    .getUsername(),
                new TypeReference<String>() {});
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = completeTestBackendBcService.executeAddUser(ca1);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        ca2 =
            ObjectMapperUtil.convertValue(
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<CompleteTestBackendBcAddUserOkResponseResponseDto>() {})
                    .getUsername(),
                new TypeReference<String>() {});
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeGetIdByUsername(ca2);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op1 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetIdByUsernameOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = completeTestBackendBcService.executeCruds(op1.getId());

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op2 =
            ObjectMapperUtil.convertValue(
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<CompleteTestBackendBcCrudsOkResponseResponseDto>() {})
                    .getUsername(),
                new TypeReference<String>() {});
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = completeTestBackendBcService.executeCustomsAndRest(op2);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op3 =
            ObjectMapperUtil.convertValue(
                _backendResponse.getBody(),
                new TypeReference<CompleteTestBackendBcCustomsAndRestOkResponseResponseDto>() {});
      }

    } catch (Exception e) {
      throw new CadException("ERR-COMP-001", e.getCause());
    }
    return BackendResponse.builder()
        .body(
            CompleteTestBackendBcCompleteBackendExampleOkResponseResponseDto.builder()
                .data(
                    ObjectMapperUtil.convertValue(
                        op3,
                        new TypeReference<
                            CompleteTestBackendBcCompleteBackendExampleOutDataDto>() {}))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeAddUser(String username) throws CadException {

    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeInsertUser(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            CompleteTestBackendBcAddUserOkResponseResponseDto.builder().username(username).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeCruds(Long id) throws CadException {

    User op4 = null;

    User op3 = null;

    User op2 = null;
    List<User> op5 = new ArrayList<>();
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = userCRUDService.executeGetUser(id);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op4 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetUserCRUDOkResponseResponseDto>() {})
                .getOutputDomainEntity();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = userCRUDService.executeDeleteUserCrud(op4.getId());

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse =
          userCRUDService.executeAddUserCrud(
              ObjectMapperUtil.convertValue(op4, new TypeReference<User>() {}));

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op3 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<AddUserCrudCRUDOkResponseResponseDto>() {})
                .getOutputDomainEntity();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse =
          userCRUDService.executeUpdateUser(
              op3.getId(), ObjectMapperUtil.convertValue(op3, new TypeReference<User>() {}));

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op2 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<UpdateUserCRUDOkResponseResponseDto>() {})
                .getOutputDomainEntity();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = userCRUDService.executeGetAllUsers();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        op5 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetAllUsersCRUDOkResponseResponseDto>() {})
                .getOutputDomainEntityList();
      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            CompleteTestBackendBcCrudsOkResponseResponseDto.builder()
                .username(op2.getUsername())
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }
}
