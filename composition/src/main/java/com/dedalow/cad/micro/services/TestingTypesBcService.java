package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import java.math.BigDecimal;
import java.util.List;

public interface TestingTypesBcService {

  public BackendResponse<?> executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<TestingTypesBcValidateTypesInTypeListDataDto> typeList,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString,
      TestingTypesBcValidateTypesInTypeObjectDto typeObject)
      throws CadException;

  public BackendResponse<?> executeDeleteAll() throws CadException;
}
