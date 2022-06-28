package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.LoadDataBcLoadDatabaseOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.LoadDataBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoadDataBcServiceImpl implements LoadDataBcService {

  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeLoadDatabase() throws CadException {

    try {

      sqlService.executeDeleteUserTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteUsuarioTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteTitulosTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteGeneroTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteProductTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteTypeProductTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeDeleteUsuarioTransTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertUsertTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertUsuarioTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertTitulosTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertGeneroTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertProductTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertTypeProductTest();

    } catch (Exception e) {
    }
    try {

      sqlService.executeInsertUsuarioTransTest();

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(LoadDataBcLoadDatabaseOkResponseResponseDto.builder().build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
