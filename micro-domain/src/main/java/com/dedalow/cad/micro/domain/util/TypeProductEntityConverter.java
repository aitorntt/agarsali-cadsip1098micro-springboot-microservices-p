package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeProductEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.TypeProduct convertToModel(
      TypeProduct typeProduct) {
    if (Objects.isNull(typeProduct)) return null;

    com.dedalow.cad.micro.commons.model.TypeProduct typeProductModel =
        new com.dedalow.cad.micro.commons.model.TypeProduct();

    typeProductModel.setName(typeProduct.getName());
    typeProductModel.setId(typeProduct.getId());
    return typeProductModel;
  }

  public static TypeProduct convertToEntity(
      com.dedalow.cad.micro.commons.model.TypeProduct typeProduct) {
    if (Objects.isNull(typeProduct)) return null;

    TypeProduct typeProductEntity = new TypeProduct(typeProduct.getId());

    typeProductEntity.setName(typeProduct.getName());
    return typeProductEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.TypeProduct> convertToModel(
      List<TypeProduct> typeProductList) {
    if (Objects.isNull(typeProductList)) return null;

    List<com.dedalow.cad.micro.commons.model.TypeProduct> typeProductModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.TypeProduct>();

    for (TypeProduct typeProduct : typeProductList) {
      typeProductModelList.add(convertToModel(typeProduct));
    }
    return typeProductModelList;
  }

  public static List<TypeProduct> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.TypeProduct> typeProductList) {
    if (Objects.isNull(typeProductList)) return null;

    List<TypeProduct> typeProductEntityList = new LinkedList<TypeProduct>();

    for (com.dedalow.cad.micro.commons.model.TypeProduct typeProduct : typeProductList) {
      typeProductEntityList.add(convertToEntity(typeProduct));
    }
    return typeProductEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.TypeProduct convertToModelWithRelations(
      TypeProduct typeProduct) {
    if (Objects.isNull(typeProduct)) return null;

    com.dedalow.cad.micro.commons.model.TypeProduct typeProductModel = convertToModel(typeProduct);

    return typeProductModel;
  }

  public static TypeProduct convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.TypeProduct typeProduct) {
    if (Objects.isNull(typeProduct)) return null;

    TypeProduct typeProductEntity = convertToEntity(typeProduct);

    return typeProductEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.TypeProduct> convertToModelWithRelations(
      List<TypeProduct> typeProductList) {
    if (Objects.isNull(typeProductList)) return null;
    List<com.dedalow.cad.micro.commons.model.TypeProduct> typeProductModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.TypeProduct>();

    for (TypeProduct typeProduct : typeProductList) {
      typeProductModelList.add(convertToModelWithRelations(typeProduct));
    }
    return typeProductModelList;
  }

  public static List<TypeProduct> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.TypeProduct> typeProductList) {
    if (Objects.isNull(typeProductList)) return null;
    List<TypeProduct> typeProductEntityList = new LinkedList<TypeProduct>();

    for (com.dedalow.cad.micro.commons.model.TypeProduct typeProduct : typeProductList) {
      typeProductEntityList.add(convertToEntityWithRelations(typeProduct));
    }
    return typeProductEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    TypeProductEntityConverter.encodeService = encodeService;
  }
}
