package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import java.math.BigDecimal;
import java.util.List;

public interface AllExternalCodesEcService {

  public BackendResponse<?> executeAddGeneros(
      List<AllExternalCodesEcAddGenerosInPeliculasDataDto> peliculas,
      BigDecimal valoracionMedia,
      List<AllExternalCodesEcAddGenerosInGenerosDataDto> generos,
      String genero);

  public BackendResponse<?> executeCastDecimal(BigDecimal inputValue);

  public BackendResponse<?> executeGetIntegerValue();

  public BackendResponse<?> executeTestExternalCode(String username);

  public BackendResponse<?> executeSumatorio(Integer sumatorio, Integer iterate);

  public BackendResponse<?> executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<AllExternalCodesEcValidateTypesInTypeListDataDto> typeList,
      Long typeLong,
      String typeLongText,
      AllExternalCodesEcValidateTypesInTypeObjectDto typeObject,
      String typePassword,
      String typeString);

  public BackendResponse<?> executeChangeValue();

  public BackendResponse<?> executeChangeVar(Integer var);

  public BackendResponse<?> executeCastInteger(Integer inputValue);

  public BackendResponse<?> executeEmptyExternal(Integer typeValue);

  public BackendResponse<?> executeRollbackChangeVar(Integer var);

  public BackendResponse<?> executeJoinPeliculas(
      List<AllExternalCodesEcJoinPeliculasInPeliculasDataDto> peliculas,
      List<AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto> peliculasAll);

  public BackendResponse<?> executeCastLong(Long inputValue);

  public BackendResponse<?> executeListaPeliculas();

  public BackendResponse<?> executeSumaValoracion(Integer valoracion, Integer valoracionElementos);

  public BackendResponse<?> executeCastString(String inputValue);

  public BackendResponse<?> executeValoracionMedia(Integer valoracion, List<String> elementos);
}
