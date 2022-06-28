package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestOtherCompositionBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestOtherCompositionBcServiceImpl implements TestOtherCompositionBcService {

  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeTestOtherComposition(String username) throws CadException {

    String ca2 = "";

    try {

      ca2 = allExternalCodesEcService.executeTestExternalCode(username);

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteUser(ca2);

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            TestOtherCompositionBcTestOtherCompositionOkResponseResponseDto.builder()
                .username(ca2)
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
