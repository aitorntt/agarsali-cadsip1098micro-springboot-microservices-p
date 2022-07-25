package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTransactionalBcTestingTransactionalOutDataDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.ForceFailOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingTransactionalBcRetTransactionalOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingTransactionalBcTestingTransactionalOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingTransactionalBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingTransactionalBcServiceImpl implements TestingTransactionalBcService {

  @Autowired SqlMapper sqlService;
  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired TestingTransactionalBcService testingTransactionalBcService;

  @Override
  public BackendResponse<?> executeRetTransactional(String username) throws CadException {

    Integer var = Integer.valueOf(10);

    List<ForceFailOutOutputSQLResultDataDto> userFail = new ArrayList<>();
    BackendResponse<?> _backendResponse = null;

    boolean transactional_varExternal1 = false;

    try {

      _backendResponse = sqlService.executeDeleteUsuarioTransByName(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

      _backendResponse = allExternalCodesEcService.executeChangeVar(var);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

      transactional_varExternal1 = true;

      _backendResponse = sqlService.executeForceFail(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        userFail =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<ForceFailOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

      return BackendResponse.builder()
          .body(
              TestingTransactionalBcRetTransactionalOkResponseResponseDto.builder()
                  .var(var)
                  .build())
          .isOk(true)
          .statusCode(200)
          .build();
    } catch (Exception e) {
      if (transactional_varExternal1) {

        _backendResponse = allExternalCodesEcService.executeRollbackChangeVar(var);

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {

        }
      }
      throw new CadException(e.getMessage());
    }
  }

  @Override
  public BackendResponse<?> executeTestingTransactional(String username) throws CadException {

    Integer call = null;

    GetUsuarioTransOutOutputSQLResultDto usuario = null;
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = testingTransactionalBcService.executeRetTransactional(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        call =
            ObjectMapperUtil.convertValue(
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<
                            TestingTransactionalBcRetTransactionalOkResponseResponseDto>() {})
                    .getVar(),
                new TypeReference<Integer>() {});
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeGetUsuarioTrans(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        usuario =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetUsuarioTransOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            TestingTransactionalBcTestingTransactionalOkResponseResponseDto.builder()
                .data(
                    ObjectMapperUtil.convertValue(
                        usuario,
                        new TypeReference<
                            TestingTransactionalBcTestingTransactionalOutDataDto>() {}))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }
}
