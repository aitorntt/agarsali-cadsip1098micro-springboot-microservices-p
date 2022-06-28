package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GeneroEntityConverter {

  public static com.dedalow.cad.micro.commons.model.Genero convertToModel(Genero genero) {
    if (Objects.isNull(genero)) return null;

    com.dedalow.cad.micro.commons.model.Genero generoModel =
        new com.dedalow.cad.micro.commons.model.Genero();

    generoModel.setNombre(genero.getNombre());
    generoModel.setId(genero.getId());
    return generoModel;
  }

  public static Genero convertToEntity(com.dedalow.cad.micro.commons.model.Genero genero) {
    if (Objects.isNull(genero)) return null;

    Genero generoEntity = new Genero(genero.getId());

    generoEntity.setNombre(genero.getNombre());
    return generoEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Genero> convertToModel(
      List<Genero> generoList) {
    if (Objects.isNull(generoList)) return null;

    List<com.dedalow.cad.micro.commons.model.Genero> generoModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Genero>();

    for (Genero genero : generoList) {
      generoModelList.add(convertToModel(genero));
    }
    return generoModelList;
  }

  public static List<Genero> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.Genero> generoList) {
    if (Objects.isNull(generoList)) return null;

    List<Genero> generoEntityList = new LinkedList<Genero>();

    for (com.dedalow.cad.micro.commons.model.Genero genero : generoList) {
      generoEntityList.add(convertToEntity(genero));
    }
    return generoEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.Genero convertToModelWithRelations(
      Genero genero) {
    if (Objects.isNull(genero)) return null;

    com.dedalow.cad.micro.commons.model.Genero generoModel = convertToModel(genero);

    return generoModel;
  }

  public static Genero convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.Genero genero) {
    if (Objects.isNull(genero)) return null;

    Genero generoEntity = convertToEntity(genero);

    return generoEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Genero> convertToModelWithRelations(
      List<Genero> generoList) {
    if (Objects.isNull(generoList)) return null;
    List<com.dedalow.cad.micro.commons.model.Genero> generoModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Genero>();

    for (Genero genero : generoList) {
      generoModelList.add(convertToModelWithRelations(genero));
    }
    return generoModelList;
  }

  public static List<Genero> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.Genero> generoList) {
    if (Objects.isNull(generoList)) return null;
    List<Genero> generoEntityList = new LinkedList<Genero>();

    for (com.dedalow.cad.micro.commons.model.Genero genero : generoList) {
      generoEntityList.add(convertToEntityWithRelations(genero));
    }
    return generoEntityList;
  }
}
