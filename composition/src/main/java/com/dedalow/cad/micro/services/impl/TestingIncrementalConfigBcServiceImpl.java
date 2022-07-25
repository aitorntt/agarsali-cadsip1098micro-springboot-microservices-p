package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcSumatorioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.GetGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingIncrementalConfigBcCountGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingIncrementalConfigBcSumaParesOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingIncrementalConfigBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingIncrementalConfigBcServiceImpl implements TestingIncrementalConfigBcService {

  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;
  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeSumaPares() throws CadException {

    Integer sumatorio = Integer.valueOf(0);

    BackendResponse<?> _backendResponse = null;

    Integer i = Integer.valueOf(0);
    while (i <= 20) {

      try {

        _backendResponse = allExternalCodesEcService.executeSumatorio(sumatorio, i);

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          sumatorio =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<AllExternalCodesEcSumatorioOkResponseResponseDto>() {})
                  .getSumatorio();
        }

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
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeCountGeneros() throws CadException {

    List<GetGenerosOutOutputSQLResultDataDto> generos = new ArrayList<>();
    Integer sumatorio = 0;
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeGetGeneros();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        generos =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetGenerosOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
    }
    Integer i = 0;
    while (i < generos.size()) {

      i = i + generos.size();

      try {

        _backendResponse = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          sumatorio =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<AllExternalCodesEcSumatorioOkResponseResponseDto>() {})
                  .getSumatorio();
        }

      } catch (Exception e) {
      }
    }
    Integer z = 0;
    do {
      try {

        _backendResponse = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          sumatorio =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<AllExternalCodesEcSumatorioOkResponseResponseDto>() {})
                  .getSumatorio();
        }

      } catch (Exception e) {
      }
      z++;
    } while (z < generos.size());

    Integer x = 0;
    while (x < generos.size()) {

      try {

        _backendResponse = allExternalCodesEcService.executeSumatorio(sumatorio, generos.size());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          sumatorio =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<AllExternalCodesEcSumatorioOkResponseResponseDto>() {})
                  .getSumatorio();
        }

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
        .statusCode(200)
        .build();
  }
}
