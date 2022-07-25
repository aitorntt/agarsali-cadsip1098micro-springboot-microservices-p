package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidNamesEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.ValidNames convertToModel(
      ValidNames validNames) {
    if (Objects.isNull(validNames)) return null;

    com.dedalow.cad.micro.commons.model.ValidNames validNamesModel =
        new com.dedalow.cad.micro.commons.model.ValidNames();

    validNamesModel.setName(validNames.getName());
    validNamesModel.setId(validNames.getId());
    return validNamesModel;
  }

  public static ValidNames convertToEntity(
      com.dedalow.cad.micro.commons.model.ValidNames validNames) {
    if (Objects.isNull(validNames)) return null;

    ValidNames validNamesEntity = new ValidNames(validNames.getId());

    validNamesEntity.setName(validNames.getName());
    return validNamesEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidNames> convertToModel(
      List<ValidNames> validNamesList) {
    if (Objects.isNull(validNamesList)) return null;

    List<com.dedalow.cad.micro.commons.model.ValidNames> validNamesModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidNames>();

    for (ValidNames validNames : validNamesList) {
      validNamesModelList.add(convertToModel(validNames));
    }
    return validNamesModelList;
  }

  public static List<ValidNames> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.ValidNames> validNamesList) {
    if (Objects.isNull(validNamesList)) return null;

    List<ValidNames> validNamesEntityList = new LinkedList<ValidNames>();

    for (com.dedalow.cad.micro.commons.model.ValidNames validNames : validNamesList) {
      validNamesEntityList.add(convertToEntity(validNames));
    }
    return validNamesEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.ValidNames convertToModelWithRelations(
      ValidNames validNames) {
    if (Objects.isNull(validNames)) return null;

    com.dedalow.cad.micro.commons.model.ValidNames validNamesModel = convertToModel(validNames);

    return validNamesModel;
  }

  public static ValidNames convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.ValidNames validNames) {
    if (Objects.isNull(validNames)) return null;

    ValidNames validNamesEntity = convertToEntity(validNames);

    return validNamesEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidNames> convertToModelWithRelations(
      List<ValidNames> validNamesList) {
    if (Objects.isNull(validNamesList)) return null;
    List<com.dedalow.cad.micro.commons.model.ValidNames> validNamesModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidNames>();

    for (ValidNames validNames : validNamesList) {
      validNamesModelList.add(convertToModelWithRelations(validNames));
    }
    return validNamesModelList;
  }

  public static List<ValidNames> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.ValidNames> validNamesList) {
    if (Objects.isNull(validNamesList)) return null;
    List<ValidNames> validNamesEntityList = new LinkedList<ValidNames>();

    for (com.dedalow.cad.micro.commons.model.ValidNames validNames : validNamesList) {
      validNamesEntityList.add(convertToEntityWithRelations(validNames));
    }
    return validNamesEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    ValidNamesEntityConverter.encodeService = encodeService;
  }
}
