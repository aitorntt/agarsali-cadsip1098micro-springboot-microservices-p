package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.Usuario convertToModel(Usuario usuario) {
    if (Objects.isNull(usuario)) return null;

    com.dedalow.cad.micro.commons.model.Usuario usuarioModel =
        new com.dedalow.cad.micro.commons.model.Usuario();

    usuarioModel.setUsername(usuario.getUsername());

    usuarioModel.setNombre(usuario.getNombre());

    usuarioModel.setApellidos(usuario.getApellidos());

    usuarioModel.setEdad(usuario.getEdad());
    usuarioModel.setId(usuario.getId());
    return usuarioModel;
  }

  public static Usuario convertToEntity(com.dedalow.cad.micro.commons.model.Usuario usuario) {
    if (Objects.isNull(usuario)) return null;

    Usuario usuarioEntity = new Usuario(usuario.getId());

    usuarioEntity.setUsername(usuario.getUsername());

    usuarioEntity.setNombre(usuario.getNombre());

    usuarioEntity.setApellidos(usuario.getApellidos());

    usuarioEntity.setEdad(usuario.getEdad());
    return usuarioEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Usuario> convertToModel(
      List<Usuario> usuarioList) {
    if (Objects.isNull(usuarioList)) return null;

    List<com.dedalow.cad.micro.commons.model.Usuario> usuarioModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Usuario>();

    for (Usuario usuario : usuarioList) {
      usuarioModelList.add(convertToModel(usuario));
    }
    return usuarioModelList;
  }

  public static List<Usuario> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.Usuario> usuarioList) {
    if (Objects.isNull(usuarioList)) return null;

    List<Usuario> usuarioEntityList = new LinkedList<Usuario>();

    for (com.dedalow.cad.micro.commons.model.Usuario usuario : usuarioList) {
      usuarioEntityList.add(convertToEntity(usuario));
    }
    return usuarioEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.Usuario convertToModelWithRelations(
      Usuario usuario) {
    if (Objects.isNull(usuario)) return null;

    com.dedalow.cad.micro.commons.model.Usuario usuarioModel = convertToModel(usuario);

    return usuarioModel;
  }

  public static Usuario convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.Usuario usuario) {
    if (Objects.isNull(usuario)) return null;

    Usuario usuarioEntity = convertToEntity(usuario);

    return usuarioEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Usuario> convertToModelWithRelations(
      List<Usuario> usuarioList) {
    if (Objects.isNull(usuarioList)) return null;
    List<com.dedalow.cad.micro.commons.model.Usuario> usuarioModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Usuario>();

    for (Usuario usuario : usuarioList) {
      usuarioModelList.add(convertToModelWithRelations(usuario));
    }
    return usuarioModelList;
  }

  public static List<Usuario> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.Usuario> usuarioList) {
    if (Objects.isNull(usuarioList)) return null;
    List<Usuario> usuarioEntityList = new LinkedList<Usuario>();

    for (com.dedalow.cad.micro.commons.model.Usuario usuario : usuarioList) {
      usuarioEntityList.add(convertToEntityWithRelations(usuario));
    }
    return usuarioEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    UsuarioEntityConverter.encodeService = encodeService;
  }
}
