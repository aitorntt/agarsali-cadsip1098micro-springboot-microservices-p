package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestingIncrementalConfigBcCountGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingIncrementalConfigBcSumaParesOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingIncrementalConfigBcService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestingIncrementalConfigBcServiceImpl implements TestingIncrementalConfigBcService {

  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeSumaPares() throws CadException {

    Integer sumatorio = Integer.valueOf(0);

    Integer i = Integer.valueOf(0);
    while (i <= 20) {

      try {

        sumatorio = allExternalCodesEcService.executeSumatorio(sumatorio, i);

      } catch (Exception e) {
      }
      i = i + 2;
    }
    return BackendResponse.builder()
        .body(
            TestingIncrementalConfigBcSumaParesOkResponseResponseDto.builder()
                .sumatorio(sumatorio)
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }

  @Override
  public BackendResponse<?> executeCountGeneros() throws CadException {

    List<GetGenerosOutOutputSQLResultDataDto> generos = new ArrayList<>();
    Integer sumatorio = 0;

    try {

      generos = sqlService.executeGetGeneros();

    } catch (Exception e) {
    }
    Integer i = 0;
    while (i < generos.size()) {

      i = i + generos.size();

      try {

        sumatorio = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

      } catch (Exception e) {
      }
    }
    Integer z = 0;
    do {
      try {

        sumatorio = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

      } catch (Exception e) {
      }
      z++;
    } while (z < generos.size());

    Integer x = 0;
    while (x < generos.size()) {

      try {

        sumatorio = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

      } catch (Exception e) {
      }
      x++;
    }
    return BackendResponse.builder()
        .body(
            TestingIncrementalConfigBcCountGenerosOkResponseResponseDto.builder()
                .countGeneros(generos.size())
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
