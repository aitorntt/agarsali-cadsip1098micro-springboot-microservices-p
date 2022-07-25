package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateListEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.ValidateList convertToModel(
      ValidateList validateList) {
    if (Objects.isNull(validateList)) return null;

    com.dedalow.cad.micro.commons.model.ValidateList validateListModel =
        new com.dedalow.cad.micro.commons.model.ValidateList();

    validateListModel.setPrice(validateList.getPrice());
    validateListModel.setId(validateList.getId());
    return validateListModel;
  }

  public static ValidateList convertToEntity(
      com.dedalow.cad.micro.commons.model.ValidateList validateList) {
    if (Objects.isNull(validateList)) return null;

    ValidateList validateListEntity = new ValidateList(validateList.getId());

    validateListEntity.setPrice(validateList.getPrice());
    return validateListEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateList> convertToModel(
      List<ValidateList> validateListList) {
    if (Objects.isNull(validateListList)) return null;

    List<com.dedalow.cad.micro.commons.model.ValidateList> validateListModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateList>();

    for (ValidateList validateList : validateListList) {
      validateListModelList.add(convertToModel(validateList));
    }
    return validateListModelList;
  }

  public static List<ValidateList> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.ValidateList> validateListList) {
    if (Objects.isNull(validateListList)) return null;

    List<ValidateList> validateListEntityList = new LinkedList<ValidateList>();

    for (com.dedalow.cad.micro.commons.model.ValidateList validateList : validateListList) {
      validateListEntityList.add(convertToEntity(validateList));
    }
    return validateListEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.ValidateList convertToModelWithRelations(
      ValidateList validateList) {
    if (Objects.isNull(validateList)) return null;

    com.dedalow.cad.micro.commons.model.ValidateList validateListModel =
        convertToModel(validateList);

    return validateListModel;
  }

  public static ValidateList convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.ValidateList validateList) {
    if (Objects.isNull(validateList)) return null;

    ValidateList validateListEntity = convertToEntity(validateList);

    return validateListEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateList> convertToModelWithRelations(
      List<ValidateList> validateListList) {
    if (Objects.isNull(validateListList)) return null;
    List<com.dedalow.cad.micro.commons.model.ValidateList> validateListModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateList>();

    for (ValidateList validateList : validateListList) {
      validateListModelList.add(convertToModelWithRelations(validateList));
    }
    return validateListModelList;
  }

  public static List<ValidateList> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.ValidateList> validateListList) {
    if (Objects.isNull(validateListList)) return null;
    List<ValidateList> validateListEntityList = new LinkedList<ValidateList>();

    for (com.dedalow.cad.micro.commons.model.ValidateList validateList : validateListList) {
      validateListEntityList.add(convertToEntityWithRelations(validateList));
    }
    return validateListEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    ValidateListEntityConverter.encodeService = encodeService;
  }
}
