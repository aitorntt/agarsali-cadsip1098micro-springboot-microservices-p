package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcTestExternalCodeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestOtherCompositionBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestOtherCompositionBcServiceImpl implements TestOtherCompositionBcService {

  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeTestOtherComposition(String username) throws CadException {

    String ca2 = "";
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = allExternalCodesEcService.executeTestExternalCode(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        ca2 =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<AllExternalCodesEcTestExternalCodeOkResponseResponseDto>() {})
                .getUsername();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteUser(ca2);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto.builder()
                .username(ca2)
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }
}
