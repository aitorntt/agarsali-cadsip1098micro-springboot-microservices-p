package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasAllOutPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasUserDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopOutInfoSeriesDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopOutInfoSeriesSeriesFixList1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopStartGenerosFinalDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingConditionalLoopBcTestingConditionalLoopStartPeliculasFinalPeliculaDto;
import com.dedalow.cad.micro.commons.dto.response.AllExternalCodesEcAddGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.GetGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasAllOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingConditionalLoopBcTestingConditionalLoopOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.operatorBlocks.OperatorBlockDivision;
import com.dedalow.cad.micro.commons.operatorBlocks.OperatorBlockSum;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.AllExternalCodesEcMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingConditionalLoopBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingConditionalLoopBcServiceImpl implements TestingConditionalLoopBcService {

  @Autowired SqlMapper sqlService;
  @Autowired AllExternalCodesEcMapper allExternalCodesEcService;

  @Override
  public BackendResponse<?> executeTestingConditionalLoop(String username) throws CadException {

    List<TestingConditionalLoopBcTestingConditionalLoopStartGenerosFinalDataDto> generosFinal =
        new ArrayList<>();
    Integer valoracionSeries = Integer.valueOf(0);
    List<TestingConditionalLoopBcTestingConditionalLoopStartPeliculasFinalPeliculaDto>
        peliculasFinal = new ArrayList<>();

    GetUsuarioOutOutputSQLResultDto user = null;
    List<GetGenerosOutOutputSQLResultDataDto> generos = new ArrayList<>();
    List<GetPeliculasMenor5OutOutputSQLResultDataDto> peliculas = new ArrayList<>();
    List<GetPeliculasAllOutPeliculasAllDataDto> peliculasAll = new ArrayList<>();
    List<GetSeriesMenor5OutOutputSQLResultDataDto> series = new ArrayList<>();
    BigDecimal valoracionMediaSeries = new BigDecimal(0);
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeGetUsuario(username);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        user =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetUsuarioOkResponseResponseDto>() {})
                .getOutputSQLResult();
      }

    } catch (Exception e) {
    }
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
    do {
      Integer valoracionPeliculas = Integer.valueOf(0);
      BigDecimal valoracionMediaPeliculas = new BigDecimal(0);
      if (user.getEdad() < 18) {

        if (user.getEdad() < 5) {

          try {

            _backendResponse = sqlService.executeGetPeliculasMenor5(generos.get(i).getId());

            if (!_backendResponse.isOk()) {
              throw new CadException(_backendResponse.getMessage());
            } else {
              peliculas =
                  ObjectMapperUtil.convertValue(
                          _backendResponse.getBody(),
                          new TypeReference<GetPeliculasMenor5OkResponseResponseDto>() {})
                      .getOutputSQLResult();
            }

          } catch (Exception e) {
          }
        } else {
          try {

            _backendResponse = sqlService.executeGetPeliculasMenor5Hasta18(generos.get(i).getId());

            if (!_backendResponse.isOk()) {
              throw new CadException(_backendResponse.getMessage());
            } else {
              peliculas =
                  ObjectMapperUtil.convertValue(
                      ObjectMapperUtil.convertValue(
                              _backendResponse.getBody(),
                              new TypeReference<
                                  GetPeliculasMenor5Hasta18OkResponseResponseDto>() {})
                          .getOutputSQLResult(),
                      new TypeReference<List<GetPeliculasMenor5OutOutputSQLResultDataDto>>() {});
            }

          } catch (Exception e) {
          }
        }
      } else {
        try {

          _backendResponse = sqlService.executeGetPeliculasMayor18(generos.get(i).getId());

          if (!_backendResponse.isOk()) {
            throw new CadException(_backendResponse.getMessage());
          } else {
            peliculas =
                ObjectMapperUtil.convertValue(
                    ObjectMapperUtil.convertValue(
                            _backendResponse.getBody(),
                            new TypeReference<GetPeliculasMayor18OkResponseResponseDto>() {})
                        .getOutputSQLResult(),
                    new TypeReference<List<GetPeliculasMenor5OutOutputSQLResultDataDto>>() {});
          }

        } catch (Exception e) {
        }
      }
      try {

        _backendResponse = sqlService.executeGetPeliculasAll(generos.get(i).getId());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          peliculasAll =
              ObjectMapperUtil.convertValue(
                      _backendResponse.getBody(),
                      new TypeReference<GetPeliculasAllOkResponseResponseDto>() {})
                  .getPeliculasAll();
        }

      } catch (Exception e) {
      }
      try {
        peliculasFinal =
            ObjectMapperUtil.convertValue(
                OperatorBlockSum.executeSumList(peliculas, peliculasAll),
                new TypeReference<
                    List<
                        TestingConditionalLoopBcTestingConditionalLoopStartPeliculasFinalPeliculaDto>>() {});
      } catch (Exception e) {
      }
      for (Integer z = 0; z < peliculasFinal.size(); z++) {
        try {
          valoracionPeliculas =
              OperatorBlockSum.executeSumInteger(
                  valoracionPeliculas, peliculasFinal.get(z).getValoracion());

        } catch (Exception e) {
        }
      }
      try {
        valoracionMediaPeliculas =
            OperatorBlockDivision.executeDivisionDecimal(
                valoracionPeliculas, peliculasFinal.size());

      } catch (Exception e) {
      }
      try {

        _backendResponse =
            allExternalCodesEcService.executeAddGeneros(
                ObjectMapperUtil.convertValue(
                    peliculasFinal,
                    new TypeReference<List<AllExternalCodesEcAddGenerosInPeliculasDataDto>>() {}),
                valoracionMediaPeliculas,
                ObjectMapperUtil.convertValue(
                    generosFinal,
                    new TypeReference<List<AllExternalCodesEcAddGenerosInGenerosDataDto>>() {}),
                generos.get(i).getNombre());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          generosFinal =
              ObjectMapperUtil.convertValue(
                  ObjectMapperUtil.convertValue(
                          _backendResponse.getBody(),
                          new TypeReference<AllExternalCodesEcAddGenerosOkResponseResponseDto>() {})
                      .getGeneros(),
                  new TypeReference<
                      List<
                          TestingConditionalLoopBcTestingConditionalLoopStartGenerosFinalDataDto>>() {});
        }

      } catch (Exception e) {
      }
      i++;
    } while (i < generos.size());

    if (user.getEdad() < 18) {

      if (user.getEdad() < 5) {

        try {

          _backendResponse = sqlService.executeGetSeriesMenor5();
          if (!_backendResponse.isOk()) {
            throw new CadException(_backendResponse.getMessage());
          } else {
            series =
                ObjectMapperUtil.convertValue(
                        _backendResponse.getBody(),
                        new TypeReference<GetSeriesMenor5OkResponseResponseDto>() {})
                    .getOutputSQLResult();
          }

        } catch (Exception e) {
        }
      } else {
        try {

          _backendResponse = sqlService.executeGetSeriesMenor5Hasta18();
          if (!_backendResponse.isOk()) {
            throw new CadException(_backendResponse.getMessage());
          } else {
            series =
                ObjectMapperUtil.convertValue(
                    ObjectMapperUtil.convertValue(
                            _backendResponse.getBody(),
                            new TypeReference<GetSeriesMenor5Hasta18OkResponseResponseDto>() {})
                        .getOutputSQLResult(),
                    new TypeReference<List<GetSeriesMenor5OutOutputSQLResultDataDto>>() {});
          }

        } catch (Exception e) {
        }
      }
    } else {
      try {

        _backendResponse = sqlService.executeGetSeriesMayor18();
        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {
          series =
              ObjectMapperUtil.convertValue(
                  ObjectMapperUtil.convertValue(
                          _backendResponse.getBody(),
                          new TypeReference<GetSeriesMayor18OkResponseResponseDto>() {})
                      .getOutputSQLResult(),
                  new TypeReference<List<GetSeriesMenor5OutOutputSQLResultDataDto>>() {});
        }

      } catch (Exception e) {
      }
    }
    for (Integer z = 0; z < series.size(); z++) {
      try {
        valoracionSeries =
            OperatorBlockSum.executeSumInteger(valoracionSeries, series.get(z).getValoracion());

      } catch (Exception e) {
      }
    }
    try {
      valoracionMediaSeries =
          OperatorBlockDivision.executeDivisionDecimal(valoracionSeries, series.size());

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            TestingConditionalLoopBcTestingConditionalLoopOkResponseResponseDto.builder()
                .infoPeliculas(
                    TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasDto.builder()
                        .user(
                            ObjectMapperUtil.convertValue(
                                user,
                                new TypeReference<
                                    TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasUserDto>() {}))
                        .generos(
                            ObjectMapperUtil.convertValue(
                                generosFinal,
                                new TypeReference<
                                    List<
                                        TestingConditionalLoopBcTestingConditionalLoopOutInfoPeliculasGenerosDataDto>>() {}))
                        .build())
                .infoSeries(
                    TestingConditionalLoopBcTestingConditionalLoopOutInfoSeriesDto.builder()
                        .series(
                            ObjectMapperUtil.convertValue(
                                series,
                                new TypeReference<
                                    List<
                                        TestingConditionalLoopBcTestingConditionalLoopOutInfoSeriesSeriesFixList1557Dto>>() {}))
                        .valoracionMediaSeries(valoracionMediaSeries)
                        .build())
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }
}
