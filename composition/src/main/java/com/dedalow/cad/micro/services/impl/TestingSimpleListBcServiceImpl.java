package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcChangeValueOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestingSimpleListBcTestSimpleListOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingSimpleListBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingSimpleListBcServiceImpl implements TestingSimpleListBcService {

  @Autowired SqlMapper sqlService;
  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;

  @Override
  public BackendResponse<?> executeTestSimpleList(Integer modValue, List<String> names)
      throws CadException {

    BackendResponse<?> _backendResponse = null;

    if (modValue < 10) {

      for (Integer i = 0; i < names.size(); i++) {
        try {

          _backendResponse = sqlService.executeAddValidName(names.get(i));

          if (!_backendResponse.isOk()) {
            throw new CadException(_backendResponse.getMessage());
          } else {

          }

        } catch (Exception e) {
        }
      }
      try {

        _backendResponse = allExternalCodesEcService.executeChangeValue();
        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          modValue =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<AllExternalCodesEcChangeValueOkResponseResponseDto>() {})
                  .getValue();
        }

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
        .statusCode(200)
        .build();
  }
}
