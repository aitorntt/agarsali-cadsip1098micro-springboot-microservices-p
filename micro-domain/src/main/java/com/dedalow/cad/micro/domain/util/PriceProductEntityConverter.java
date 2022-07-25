package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceProductEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.PriceProduct convertToModel(
      PriceProduct priceProduct) {
    if (Objects.isNull(priceProduct)) return null;

    com.dedalow.cad.micro.commons.model.PriceProduct priceProductModel =
        new com.dedalow.cad.micro.commons.model.PriceProduct();

    priceProductModel.setPrice(priceProduct.getPrice());

    priceProductModel.setCurrency(priceProduct.getCurrency());

    priceProductModel.setProductId(priceProduct.getProductId());
    priceProductModel.setId(priceProduct.getId());
    return priceProductModel;
  }

  public static PriceProduct convertToEntity(
      com.dedalow.cad.micro.commons.model.PriceProduct priceProduct) {
    if (Objects.isNull(priceProduct)) return null;

    PriceProduct priceProductEntity = new PriceProduct(priceProduct.getId());

    priceProductEntity.setPrice(priceProduct.getPrice());

    priceProductEntity.setCurrency(priceProduct.getCurrency());

    priceProductEntity.setProductId(priceProduct.getProductId());
    return priceProductEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.PriceProduct> convertToModel(
      List<PriceProduct> priceProductList) {
    if (Objects.isNull(priceProductList)) return null;

    List<com.dedalow.cad.micro.commons.model.PriceProduct> priceProductModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.PriceProduct>();

    for (PriceProduct priceProduct : priceProductList) {
      priceProductModelList.add(convertToModel(priceProduct));
    }
    return priceProductModelList;
  }

  public static List<PriceProduct> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.PriceProduct> priceProductList) {
    if (Objects.isNull(priceProductList)) return null;

    List<PriceProduct> priceProductEntityList = new LinkedList<PriceProduct>();

    for (com.dedalow.cad.micro.commons.model.PriceProduct priceProduct : priceProductList) {
      priceProductEntityList.add(convertToEntity(priceProduct));
    }
    return priceProductEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.PriceProduct convertToModelWithRelations(
      PriceProduct priceProduct) {
    if (Objects.isNull(priceProduct)) return null;

    com.dedalow.cad.micro.commons.model.PriceProduct priceProductModel =
        convertToModel(priceProduct);

    return priceProductModel;
  }

  public static PriceProduct convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.PriceProduct priceProduct) {
    if (Objects.isNull(priceProduct)) return null;

    PriceProduct priceProductEntity = convertToEntity(priceProduct);

    return priceProductEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.PriceProduct> convertToModelWithRelations(
      List<PriceProduct> priceProductList) {
    if (Objects.isNull(priceProductList)) return null;
    List<com.dedalow.cad.micro.commons.model.PriceProduct> priceProductModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.PriceProduct>();

    for (PriceProduct priceProduct : priceProductList) {
      priceProductModelList.add(convertToModelWithRelations(priceProduct));
    }
    return priceProductModelList;
  }

  public static List<PriceProduct> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.PriceProduct> priceProductList) {
    if (Objects.isNull(priceProductList)) return null;
    List<PriceProduct> priceProductEntityList = new LinkedList<PriceProduct>();

    for (com.dedalow.cad.micro.commons.model.PriceProduct priceProduct : priceProductList) {
      priceProductEntityList.add(convertToEntityWithRelations(priceProduct));
    }
    return priceProductEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    PriceProductEntityConverter.encodeService = encodeService;
  }
}
