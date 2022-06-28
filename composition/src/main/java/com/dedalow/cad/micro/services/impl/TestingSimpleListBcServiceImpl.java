package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestingSimpleListBcTestSimpleListOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingSimpleListBcService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestingSimpleListBcServiceImpl implements TestingSimpleListBcService {

  @Autowired SqlMapper sqlService;
  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;

  @Override
  public BackendResponse<?> executeTestSimpleList(Integer modValue, List<String> names)
      throws CadException {

    if (modValue < 10) {

      for (Integer i = 0; i < names.size(); i++) {
        try {

          sqlService.executeAddValidName(names.get(i));

        } catch (Exception e) {
        }
      }
      try {

        modValue = allExternalCodesEcService.executeChangeValue();

      } catch (Exception e) {
      }
    } else {
    }
    return BackendResponse.builder()
        .body(
            TestingSimpleListBcTestSimpleListOkResponseResponseDto.builder()
                .modValue(modValue)
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
