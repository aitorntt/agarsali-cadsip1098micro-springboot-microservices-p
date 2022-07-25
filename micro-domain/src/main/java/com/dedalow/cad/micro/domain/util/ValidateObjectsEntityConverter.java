package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateObjectsEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.ValidateObjects convertToModel(
      ValidateObjects validateObjects) {
    if (Objects.isNull(validateObjects)) return null;

    com.dedalow.cad.micro.commons.model.ValidateObjects validateObjectsModel =
        new com.dedalow.cad.micro.commons.model.ValidateObjects();

    validateObjectsModel.setName(validateObjects.getName());

    validateObjectsModel.setAge(validateObjects.getAge());
    validateObjectsModel.setId(validateObjects.getId());
    return validateObjectsModel;
  }

  public static ValidateObjects convertToEntity(
      com.dedalow.cad.micro.commons.model.ValidateObjects validateObjects) {
    if (Objects.isNull(validateObjects)) return null;

    ValidateObjects validateObjectsEntity = new ValidateObjects(validateObjects.getId());

    validateObjectsEntity.setName(validateObjects.getName());

    validateObjectsEntity.setAge(validateObjects.getAge());
    return validateObjectsEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateObjects> convertToModel(
      List<ValidateObjects> validateObjectsList) {
    if (Objects.isNull(validateObjectsList)) return null;

    List<com.dedalow.cad.micro.commons.model.ValidateObjects> validateObjectsModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateObjects>();

    for (ValidateObjects validateObjects : validateObjectsList) {
      validateObjectsModelList.add(convertToModel(validateObjects));
    }
    return validateObjectsModelList;
  }

  public static List<ValidateObjects> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.ValidateObjects> validateObjectsList) {
    if (Objects.isNull(validateObjectsList)) return null;

    List<ValidateObjects> validateObjectsEntityList = new LinkedList<ValidateObjects>();

    for (com.dedalow.cad.micro.commons.model.ValidateObjects validateObjects :
        validateObjectsList) {
      validateObjectsEntityList.add(convertToEntity(validateObjects));
    }
    return validateObjectsEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.ValidateObjects convertToModelWithRelations(
      ValidateObjects validateObjects) {
    if (Objects.isNull(validateObjects)) return null;

    com.dedalow.cad.micro.commons.model.ValidateObjects validateObjectsModel =
        convertToModel(validateObjects);

    return validateObjectsModel;
  }

  public static ValidateObjects convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.ValidateObjects validateObjects) {
    if (Objects.isNull(validateObjects)) return null;

    ValidateObjects validateObjectsEntity = convertToEntity(validateObjects);

    return validateObjectsEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.ValidateObjects>
      convertToModelWithRelations(List<ValidateObjects> validateObjectsList) {
    if (Objects.isNull(validateObjectsList)) return null;
    List<com.dedalow.cad.micro.commons.model.ValidateObjects> validateObjectsModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.ValidateObjects>();

    for (ValidateObjects validateObjects : validateObjectsList) {
      validateObjectsModelList.add(convertToModelWithRelations(validateObjects));
    }
    return validateObjectsModelList;
  }

  public static List<ValidateObjects> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.ValidateObjects> validateObjectsList) {
    if (Objects.isNull(validateObjectsList)) return null;
    List<ValidateObjects> validateObjectsEntityList = new LinkedList<ValidateObjects>();

    for (com.dedalow.cad.micro.commons.model.ValidateObjects validateObjects :
        validateObjectsList) {
      validateObjectsEntityList.add(convertToEntityWithRelations(validateObjects));
    }
    return validateObjectsEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    ValidateObjectsEntityConverter.encodeService = encodeService;
  }
}
