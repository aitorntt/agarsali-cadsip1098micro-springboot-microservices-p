package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutProductsServerActionParameterResponseDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInPricesPriceDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInProductDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.GetTypeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.SaveProductCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ShowProductsOkResponseResponseDto;
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
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse =
          productCRUDService.executeSaveProduct(
              ObjectMapperUtil.convertValue(product, new TypeReference<Product>() {}));

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        savedProduct =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<SaveProductCRUDOkResponseResponseDto>() {})
                .getOutputDomainEntity();
      }

    } catch (Exception e) {
    }
    Integer i = 0;
    do {
      try {

        _backendResponse =
            sqlService.executeSavePrice(
                prices.get(i).getPrice(), prices.get(i).getCurrency(), savedProduct.getId());

        if (!_backendResponse.isOk()) {
          throw new CadException(_backendResponse.getMessage());
        } else {

        }

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
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetProducts(Long typeId) throws CadException {

    GetTypeOutTypeDto type = null;
    List<ShowProductsOutProductsDataDto> products = new ArrayList<>();
    BackendResponse<?> _backendResponse = null;

    try {

      _backendResponse = sqlService.executeGetType(typeId);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        type =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<GetTypeOkResponseResponseDto>() {})
                .getType();
      }

    } catch (Exception e) {
    }
    try {

      _backendResponse = sqlService.executeShowProducts(typeId);

      if (!_backendResponse.isOk()) {
        throw new CadException(_backendResponse.getMessage());
      } else {
        products =
            ObjectMapperUtil.convertValue(
                    _backendResponse.getBody(),
                    new TypeReference<ShowProductsOkResponseResponseDto>() {})
                .getProducts();
      }

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
        .statusCode(200)
        .build();
  }
}
