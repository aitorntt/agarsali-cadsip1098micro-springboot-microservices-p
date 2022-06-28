package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosOutGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasOutPeliculasDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcValidateTypesInTypeObjectDto;
import java.math.BigDecimal;
import java.util.List;

public interface AllExternalCodesEcService {

  public List<AllExternalCodesEcAddGenerosOutGenerosDataDto> executeAddGeneros(
      List<AllExternalCodesEcAddGenerosInPeliculasDataDto> peliculas,
      BigDecimal valoracionMedia,
      List<AllExternalCodesEcAddGenerosInGenerosDataDto> generos,
      String genero);

  public String executeCastDecimal(BigDecimal inputValue);

  public Integer executeGetIntegerValue();

  public String executeTestExternalCode(String username);

  public Integer executeSumatorio(Integer sumatorio, Integer iterate);

  public void executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      List<AllExternalCodesEcValidateTypesInTypeListDataDto> typeList,
      Long typeLong,
      String typeLongText,
      AllExternalCodesEcValidateTypesInTypeObjectDto typeObject,
      String typePassword,
      String typeString);

  public Integer executeChangeValue();

  public void executeChangeVar(Integer var);

  public String executeCastInteger(Integer inputValue);

  public void executeEmptyExternal(Integer typeValue);

  public void executeRollbackChangeVar(Integer var);

  public List<AllExternalCodesEcJoinPeliculasOutPeliculasDataDto> executeJoinPeliculas(
      List<AllExternalCodesEcJoinPeliculasInPeliculasDataDto> peliculas,
      List<AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto> peliculasAll);

  public String executeCastLong(Long inputValue);

  public List<String> executeListaPeliculas();

  public Integer executeSumaValoracion(Integer valoracion, Integer valoracionElementos);

  public String executeCastString(String inputValue);

  public BigDecimal executeValoracionMedia(Integer valoracion, List<String> elementos);
}
