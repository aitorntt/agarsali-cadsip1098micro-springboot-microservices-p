package com.dedalow.cad.micro.domain.util;

import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.internal.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitulosEntityConverter {

  private static EncodeService encodeService;

  public static com.dedalow.cad.micro.commons.model.Titulos convertToModel(Titulos titulos) {
    if (Objects.isNull(titulos)) return null;

    com.dedalow.cad.micro.commons.model.Titulos titulosModel =
        new com.dedalow.cad.micro.commons.model.Titulos();

    titulosModel.setTitulo(titulos.getTitulo());

    titulosModel.setBaby(titulos.getBaby());

    titulosModel.setMedium(titulos.getMedium());

    titulosModel.setAdult(titulos.getAdult());

    titulosModel.setPelicula(titulos.getPelicula());

    titulosModel.setValoracion(titulos.getValoracion());

    titulosModel.setGeneroId(titulos.getGeneroId());
    titulosModel.setId(titulos.getId());
    return titulosModel;
  }

  public static Titulos convertToEntity(com.dedalow.cad.micro.commons.model.Titulos titulos) {
    if (Objects.isNull(titulos)) return null;

    Titulos titulosEntity = new Titulos(titulos.getId());

    titulosEntity.setTitulo(titulos.getTitulo());

    titulosEntity.setBaby(titulos.getBaby());

    titulosEntity.setMedium(titulos.getMedium());

    titulosEntity.setAdult(titulos.getAdult());

    titulosEntity.setPelicula(titulos.getPelicula());

    titulosEntity.setValoracion(titulos.getValoracion());

    titulosEntity.setGeneroId(titulos.getGeneroId());
    return titulosEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Titulos> convertToModel(
      List<Titulos> titulosList) {
    if (Objects.isNull(titulosList)) return null;

    List<com.dedalow.cad.micro.commons.model.Titulos> titulosModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Titulos>();

    for (Titulos titulos : titulosList) {
      titulosModelList.add(convertToModel(titulos));
    }
    return titulosModelList;
  }

  public static List<Titulos> convertToEntity(
      List<com.dedalow.cad.micro.commons.model.Titulos> titulosList) {
    if (Objects.isNull(titulosList)) return null;

    List<Titulos> titulosEntityList = new LinkedList<Titulos>();

    for (com.dedalow.cad.micro.commons.model.Titulos titulos : titulosList) {
      titulosEntityList.add(convertToEntity(titulos));
    }
    return titulosEntityList;
  }

  public static com.dedalow.cad.micro.commons.model.Titulos convertToModelWithRelations(
      Titulos titulos) {
    if (Objects.isNull(titulos)) return null;

    com.dedalow.cad.micro.commons.model.Titulos titulosModel = convertToModel(titulos);

    return titulosModel;
  }

  public static Titulos convertToEntityWithRelations(
      com.dedalow.cad.micro.commons.model.Titulos titulos) {
    if (Objects.isNull(titulos)) return null;

    Titulos titulosEntity = convertToEntity(titulos);

    return titulosEntity;
  }

  public static List<com.dedalow.cad.micro.commons.model.Titulos> convertToModelWithRelations(
      List<Titulos> titulosList) {
    if (Objects.isNull(titulosList)) return null;
    List<com.dedalow.cad.micro.commons.model.Titulos> titulosModelList =
        new LinkedList<com.dedalow.cad.micro.commons.model.Titulos>();

    for (Titulos titulos : titulosList) {
      titulosModelList.add(convertToModelWithRelations(titulos));
    }
    return titulosModelList;
  }

  public static List<Titulos> convertToEntityWithRelations(
      List<com.dedalow.cad.micro.commons.model.Titulos> titulosList) {
    if (Objects.isNull(titulosList)) return null;
    List<Titulos> titulosEntityList = new LinkedList<Titulos>();

    for (com.dedalow.cad.micro.commons.model.Titulos titulos : titulosList) {
      titulosEntityList.add(convertToEntityWithRelations(titulos));
    }
    return titulosEntityList;
  }

  @Autowired
  public void setEncodeService(EncodeService encodeService) {
    TitulosEntityConverter.encodeService = encodeService;
  }
}
