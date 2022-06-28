package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UsuarioTransEntityConverter {

  public static com.dedalow.cad.micro.commons.model.UsuarioTrans convertToModel(
      UsuarioTrans usuarioTrans) {
    if (Objects.isNull(usuarioTrans)) return null;

    com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTransModel =
        new com.dedalow.cad.micro.commons.model.UsuarioTrans();

    usuarioTransModel.setUsername(usuarioTrans.getUsername());
    usuarioTransModel.setId(usuarioTrans.getId());
    return usuarioTransModel;
  }

  public static UsuarioTrans convertToEntity(
      com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTrans) {
    if (Objects.isNull(usuarioTrans)) return null;

    UsuarioTrans usuarioTransEntity = new UsuarioTrans(usuarioTrans.getId());

    usuarioTransEntity.setUsername(usuarioTrans.getUsername());
    return usuarioTransEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.UsuarioTrans> convertToModel(
      List<UsuarioTrans> usuarioTransList) {
    if (Objects.isNull(usuarioTransList)) return null;

    List<com.dedalow.cad.micro.commons.model.UsuarioTrans> usuarioTransModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.UsuarioTrans>();

    for (UsuarioTrans usuarioTrans : usuarioTransList) {
      usuarioTransModelList.add(convertToModel(usuarioTrans));
    }
    return usuarioTransModelList;
  }

  public static List<UsuarioTrans> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.UsuarioTrans> usuarioTransList) {
    if (Objects.isNull(usuarioTransList)) return null;

    List<UsuarioTrans> usuarioTransEntityList = new LinkedList<UsuarioTrans>();

    for (com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTrans : usuarioTransList) {
      usuarioTransEntityList.add(convertToEntity(usuarioTrans));
    }
    return usuarioTransEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.UsuarioTrans convertToModelWithRelations(
      UsuarioTrans usuarioTrans) {
    if (Objects.isNull(usuarioTrans)) return null;

    com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTransModel =
        convertToModel(usuarioTrans);

    return usuarioTransModel;
  }

  public static UsuarioTrans convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTrans) {
    if (Objects.isNull(usuarioTrans)) return null;

    UsuarioTrans usuarioTransEntity = convertToEntity(usuarioTrans);

    return usuarioTransEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.UsuarioTrans> convertToModelWithRelations(
      List<UsuarioTrans> usuarioTransList) {
    if (Objects.isNull(usuarioTransList)) return null;
    List<com.dedalow.cad.micro.commons.model.UsuarioTrans> usuarioTransModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.UsuarioTrans>();

    for (UsuarioTrans usuarioTrans : usuarioTransList) {
      usuarioTransModelList.add(convertToModelWithRelations(usuarioTrans));
    }
    return usuarioTransModelList;
  }

  public static List<UsuarioTrans> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.UsuarioTrans> usuarioTransList) {
    if (Objects.isNull(usuarioTransList)) return null;
    List<UsuarioTrans> usuarioTransEntityList = new LinkedList<UsuarioTrans>();

    for (com.dedalow.cad.micro.commons.model.UsuarioTrans usuarioTrans : usuarioTransList) {
      usuarioTransEntityList.add(convertToEntityWithRelations(usuarioTrans));
    }
    return usuarioTransEntityList;
  }
}
