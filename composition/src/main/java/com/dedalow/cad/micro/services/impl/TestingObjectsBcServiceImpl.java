package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutProductsServerActionParameterResponseDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInPricesPriceDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInProductDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.TestingObjectsBcGetProductsOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.TestingObjectsBcSaveProductOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.mapper.ProductCRUDMapper;
import com.dedalow.cad.micro.mapper.SqlMapper;
import com.dedalow.cad.micro.services.TestingObjectsBcService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestingObjectsBcServiceImpl implements TestingObjectsBcService {

  @Autowired ProductCRUDMapper productCRUDService;
  @Autowired SqlMapper sqlService;

  @Override
  public BackendResponse<?> executeSaveProduct(
      TestingObjectsBcSaveProductInProductDto product,
      List<TestingObjectsBcSaveProductInPricesPriceDto> prices)
      throws CadException {

    Product savedProduct = null;

    try {

      savedProduct =
          productCRUDService.executeSaveProduct(
              ObjectMapperUtil.convertValue(product, new TypeReference<Product>() {}));

    } catch (Exception e) {
    }
    Integer i = 0;
    do {
      try {

        sqlService.executeSavePrice(
            prices.get(i).getPrice(), prices.get(i).getCurrency(), savedProduct.getId());

      } catch (Exception e) {
      }
      i++;
    } while (i < prices.size());

    return BackendResponse.builder()
        .body(
            TestingObjectsBcSaveProductOkResponseResponseDto.builder()
                .typeId(savedProduct.getTypeId())
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }

  @Override
  public BackendResponse<?> executeGetProducts(Long typeId) throws CadException {

    GetTypeOutTypeDto type = null;
    List<ShowProductsOutProductsDataDto> products = new ArrayList<>();

    try {

      type = sqlService.executeGetType(typeId);

    } catch (Exception e) {
    }
    try {

      products = sqlService.executeShowProducts(typeId);

    } catch (Exception e) {
    }
    return BackendResponse.builder()
        .body(
            TestingObjectsBcGetProductsOkResponseResponseDto.builder()
                .type(
                    ObjectMapperUtil.convertValue(
                        type, new TypeReference<TestingObjectsBcGetProductsOutTypeDto>() {}))
                .products(
                    ObjectMapperUtil.convertValue(
                        products,
                        new TypeReference<
                            List<
                                TestingObjectsBcGetProductsOutProductsServerActionParameterResponseDto>>() {}))
                .build())
        .isOk(true)
        .statusCode(HttpStatus.OK.value())
        .build();
  }
}
