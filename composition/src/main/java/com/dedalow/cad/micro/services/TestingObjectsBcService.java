package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInPricesPriceDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInProductDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import java.util.List;

public interface TestingObjectsBcService {

  public BackendResponse<?> executeSaveProduct(
      TestingObjectsBcSaveProductInProductDto product,
      List<TestingObjectsBcSaveProductInPricesPriceDto> prices)
      throws CadException;

  public BackendResponse<?> executeGetProducts(Long typeId) throws CadException;
}
