package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ValidateTypesEntityConverter {

  public static com.dedalow.cad.micro.commons.model.ValidateTypes convertToModel(
      ValidateTypes validateTypes) {
    if (Objects.isNull(validateTypes)) return null;

    com.dedalow.cad.micro.commons.model.ValidateTypes validateTypesModel =
        new com.dedalow.cad.micro.commons.model.ValidateTypes();

    validateTypesModel.setTypeBoolean(validateTypes.getTypeBoolean());

    validateTypesModel.setTypeDecimal(validateTypes.getTypeDecimal());

    validateTypesModel.setTypeInteger(validateTypes.getTypeInteger());

    validateTypesModel.setTypeLong(validateTypes.getTypeLong());

    validateTypesModel.setTypeLongText(validateTypes.getTypeLongText());

    validateTypesModel.setTypePassword(validateTypes.getTypePassword());

    validateTypesModel.setTypeString(validateTypes.getTypeString());
    validateTypesModel.setId(validateTypes.getId());
    return validateTypesModel;
  }

  public static ValidateTypes convertToEntity(
      com.dedalow.cad.micro.commons.model.ValidateTypes validateTypes) {
    if (Objects.isNull(validateTypes)) return null;

    ValidateTypes validateTypesEntity = new ValidateTypes(validateTypes.getId());

    validateTypesEntity.setTypeBoolean(validateTypes.getTypeBoolean());

    validateTypesEntity.setTypeDecimal(validateTypes.getTypeDecimal());

    validateTypesEntity.setTypeInteger(validateTypes.getTypeInteger());

    validateTypesEntity.setTypeLong(validateTypes.getTypeLong());

    validateTypesEntity.setTypeLongText(validateTypes.getTypeLongText());

    validateTypesEntity.setTypePassword(validateTypes.getTypePassword());

    validateTypesEntity.setTypeString(validateTypes.getTypeString());
    return validateTypesEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateTypes> convertToModel(
      List<ValidateTypes> validateTypesList) {
    if (Objects.isNull(validateTypesList)) return null;

    List<com.dedalow.cad.micro.commons.model.ValidateTypes> validateTypesModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateTypes>();

    for (ValidateTypes validateTypes : validateTypesList) {
      validateTypesModelList.add(convertToModel(validateTypes));
    }
    return validateTypesModelList;
  }

  public static List<ValidateTypes> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.ValidateTypes> validateTypesList) {
    if (Objects.isNull(validateTypesList)) return null;

    List<ValidateTypes> validateTypesEntityList = new LinkedList<ValidateTypes>();

    for (com.dedalow.cad.micro.commons.model.ValidateTypes validateTypes : validateTypesList) {
      validateTypesEntityList.add(convertToEntity(validateTypes));
    }
    return validateTypesEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.ValidateTypes convertToModelWithRelations(
      ValidateTypes validateTypes) {
    if (Objects.isNull(validateTypes)) return null;

    com.dedalow.cad.micro.commons.model.ValidateTypes validateTypesModel =
        convertToModel(validateTypes);

    return validateTypesModel;
  }

  public static ValidateTypes convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.ValidateTypes validateTypes) {
    if (Objects.isNull(validateTypes)) return null;

    ValidateTypes validateTypesEntity = convertToEntity(validateTypes);

    return validateTypesEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateTypes> convertToModelWithRelations(
      List<ValidateTypes> validateTypesList) {
    if (Objects.isNull(validateTypesList)) return null;
    List<com.dedalow.cad.micro.commons.model.ValidateTypes> validateTypesModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateTypes>();

    for (ValidateTypes validateTypes : validateTypesList) {
      validateTypesModelList.add(convertToModelWithRelations(validateTypes));
    }
    return validateTypesModelList;
  }

  public static List<ValidateTypes> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.ValidateTypes> validateTypesList) {
    if (Objects.isNull(validateTypesList)) return null;
    List<ValidateTypes> validateTypesEntityList = new LinkedList<ValidateTypes>();

    for (com.dedalow.cad.micro.commons.model.ValidateTypes validateTypes : validateTypesList) {
      validateTypesEntityList.add(convertToEntityWithRelations(validateTypes));
    }
    return validateTypesEntityList;
  }
}
