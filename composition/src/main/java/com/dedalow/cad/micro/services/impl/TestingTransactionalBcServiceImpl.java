package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTransactionalBcTestingTransactionalOutDataDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
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
import org.springframework.http.HttpStatus;
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

    boolean transactional_varExternal1 = false;

    try {

      sqlService.executeDeleteUsuarioTransByName(username);

      allExternalCodesEcService.executeChangeVar(var);

      transactional_varExternal1 = true;

      userFail = sqlService.executeForceFail(username);

      return BackendResponse.builder()
          .body(
              TestingTransactionalBcRetTransactionalOkResponseResponseDto.builder()
                  .var(var)
                  .build())
          .isOk(true)
          .statusCode(HttpStatus.OK.value())
          .build();
    } catch (Exception e) {
      if (transactional_varExternal1) {

        allExternalCodesEcService.executeRollbackChangeVar(var);
      }
      throw new CadException(e.getMessage());
    }
  }

  @Override
  public BackendResponse<?> executeTestingTransactional(String username) throws CadException {

    TestingTransactionalBcRetTransactionalOkResponseResponseDto call = null;

    GetUsuarioTransOutOutputSQLResultDto usuario = null;
    BackendResponse<?> _backendResponse = null;

    try {
      _backendResponse = testingTransactionalBcService.executeRetTransactional(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

        call =
            ObjectMapperUtil.convertValue(
                _backendResponse.getBody(),
                new TypeReference<
                    TestingTransactionalBcRetTransactionalOkResponseResponseDto>() {});
      }
    } catch (Exception e) {
    }
    try {

      usuario = sqlService.executeGetUsuarioTrans(username);

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
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
