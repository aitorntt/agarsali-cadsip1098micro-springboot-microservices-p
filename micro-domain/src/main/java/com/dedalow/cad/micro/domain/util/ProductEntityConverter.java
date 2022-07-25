package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.Product convertToModel(Product product) {
    if (Objects.isNull(product)) return null;

    com.dedalow.cad.micro.commons.model.Product productModel =
        new com.dedalow.cad.micro.commons.model.Product();

    productModel.setName(product.getName());

    productModel.setDescription(product.getDescription());

    productModel.setStock(product.getStock());

    productModel.setTypeId(product.getTypeId());
    productModel.setId(product.getId());
    return productModel;
  }

  public static Product convertToEntity(com.dedalow.cad.micro.commons.model.Product product) {
    if (Objects.isNull(product)) return null;

    Product productEntity = new Product(product.getId());

    productEntity.setName(product.getName());

    productEntity.setDescription(product.getDescription());

    productEntity.setStock(product.getStock());

    productEntity.setTypeId(product.getTypeId());
    return productEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Product> convertToModel(
      List<Product> productList) {
    if (Objects.isNull(productList)) return null;

    List<com.dedalow.cad.micro.commons.model.Product> productModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Product>();

    for (Product product : productList) {
      productModelList.add(convertToModel(product));
    }
    return productModelList;
  }

  public static List<Product> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.Product> productList) {
    if (Objects.isNull(productList)) return null;

    List<Product> productEntityList = new LinkedList<Product>();

    for (com.dedalow.cad.micro.commons.model.Product product : productList) {
      productEntityList.add(convertToEntity(product));
    }
    return productEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.Product convertToModelWithRelations(
      Product product) {
    if (Objects.isNull(product)) return null;

    com.dedalow.cad.micro.commons.model.Product productModel = convertToModel(product);

    return productModel;
  }

  public static Product convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.Product product) {
    if (Objects.isNull(product)) return null;

    Product productEntity = convertToEntity(product);

    return productEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Product> convertToModelWithRelations(
      List<Product> productList) {
    if (Objects.isNull(productList)) return null;
    List<com.dedalow.cad.micro.commons.model.Product> productModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Product>();

    for (Product product : productList) {
      productModelList.add(convertToModelWithRelations(product));
    }
    return productModelList;
  }

  public static List<Product> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.Product> productList) {
    if (Objects.isNull(productList)) return null;
    List<Product> productEntityList = new LinkedList<Product>();

    for (com.dedalow.cad.micro.commons.model.Product product : productList) {
      productEntityList.add(convertToEntityWithRelations(product));
    }
    return productEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    ProductEntityConverter.encodeService = encodeService;
  }
}
