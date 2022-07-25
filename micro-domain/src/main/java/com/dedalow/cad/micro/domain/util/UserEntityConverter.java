package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.User convertToModel(User user) {
    if (Objects.isNull(user)) return null;

    com.dedalow.cad.micro.commons.model.User userModel =
        new com.dedalow.cad.micro.commons.model.User();

    userModel.setUsername(user.getUsername());

    userModel.setPassword(user.getPassword());

    userModel.setEdad(user.getEdad());
    userModel.setId(user.getId());
    return userModel;
  }

  public static User convertToEntity(com.dedalow.cad.micro.commons.model.User user) {
    if (Objects.isNull(user)) return null;

    User userEntity = new User(user.getId());

    userEntity.setUsername(user.getUsername());

    userEntity.setPassword(user.getPassword());

    userEntity.setEdad(user.getEdad());
    return userEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.User> convertToModel(List<User> userList) {
    if (Objects.isNull(userList)) return null;

    List<com.dedalow.cad.micro.commons.model.User> userModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.User>();

    for (User user : userList) {
      userModelList.add(convertToModel(user));
    }
    return userModelList;
  }

  public static List<User> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.User> userList) {
    if (Objects.isNull(userList)) return null;

    List<User> userEntityList = new LinkedList<User>();

    for (com.dedalow.cad.micro.commons.model.User user : userList) {
      userEntityList.add(convertToEntity(user));
    }
    return userEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.User convertToModelWithRelations(User user) {
    if (Objects.isNull(user)) return null;

    com.dedalow.cad.micro.commons.model.User userModel = convertToModel(user);

    return userModel;
  }

  public static User convertToEntityWithRelations(com.dedalow.cad.micro.commons.model.User user) {
    if (Objects.isNull(user)) return null;

    User userEntity = convertToEntity(user);

    return userEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.User> convertToModelWithRelations(
      List<User> userList) {
    if (Objects.isNull(userList)) return null;
    List<com.dedalow.cad.micro.commons.model.User> userModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.User>();

    for (User user : userList) {
      userModelList.add(convertToModelWithRelations(user));
    }
    return userModelList;
  }

  public static List<User> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.User> userList) {
    if (Objects.isNull(userList)) return null;
    List<User> userEntityList = new LinkedList<User>();

    for (com.dedalow.cad.micro.commons.model.User user : userList) {
      userEntityList.add(convertToEntityWithRelations(user));
    }
    return userEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    UserEntityConverter.encodeService = encodeService;
  }
}
