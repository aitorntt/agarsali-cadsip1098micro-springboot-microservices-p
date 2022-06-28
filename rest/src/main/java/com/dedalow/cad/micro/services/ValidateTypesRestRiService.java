package com.dedalow.cad.micro.services;



import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import java.math.BigDecimal;
import java.util.List;

public interface ValidateTypesRestRiService {

  public BackendResponse<?> executeMicroRest(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto> typeList,
      Long typeLong,
      String typeLongText,
      ValidateTypesRestRiMicroRestInTypeObjectDto typeObject,
      String typePassword,
      String typeString)
      throws Exception;

  public BackendResponse<?> executeMicroRest(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<ValidateTypesRestRiMicroRestInTypeListFixObject1557Dto> typeList,
      Long typeLong,
      String typeLongText,
      ValidateTypesRestRiMicroRestInTypeObjectDto typeObject,
      String typePassword,
      String typeString,
      boolean sslVerification)
      throws Exception;

  public BackendResponse<?> executeMicroRestAux() throws Exception;

  public BackendResponse<?> executeMicroRestAux(boolean sslVerification) throws Exception;
}
