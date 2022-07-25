package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.LoadDataBcLoadDatabaseOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.LoadDataBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadDataBcServiceImpl implements LoadDataBcService {

  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeLoadDatabase() throws CadException {

    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeDeleteUserTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteUsuarioTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteTitulosTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteGeneroTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteProductTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteTypeProductTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeDeleteUsuarioTransTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertUsertTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertUsuarioTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertTitulosTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertGeneroTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertProductTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertTypeProductTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeInsertUsuarioTransTest();
      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {

      }

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(LoadDataBcLoadDatabaseOkResponseResponseDto.builder().build())
        .isOk(true)
        .statusCode(200)
        .build();
  }
}
