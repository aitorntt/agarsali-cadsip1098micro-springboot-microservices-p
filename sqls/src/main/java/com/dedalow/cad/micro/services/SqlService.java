package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetIdByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasAllOutPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMayor18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMayor18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5Hasta18OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5OutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetTitulosOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetTypesOutTypesDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUserByUsernameOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuariosOutUsuariosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.GetUsuariosTransOutOutputSQLResultDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import java.math.BigDecimal;
import java.util.List;

public interface SqlService {
  public void executeDeleteUsuarioTest();

  public List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> executeGetPeliculasMenor5Hasta18(
      Long generoId);

  public List<ForceFailOutOutputSQLResultDataDto> executeForceFail(String username);

  public void executeValidateList(Integer price);

  public void executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString);

  public List<GetUsuariosTransOutOutputSQLResultDataDto> executeGetUsuariosTrans();

  public void executeInsertProductTest();

  public GetUserByUsernameOutOutputSQLResultDto executeGetUserByUsername(String username);

  public void executeInsertGeneroTest();

  public void executeInsertUser(String username);

  public void executeDeleteUser(String username);

  public GetIdByUsernameOutOutputSQLResultDto executeGetIdByUsername(String username);

  public GetUsuarioOutOutputSQLResultDto executeGetUsuario(String username);

  public List<GetPeliculasAllOutPeliculasAllDataDto> executeGetPeliculasAll(Long generoId);

  public List<GetPeliculasMenor5OutOutputSQLResultDataDto> executeGetPeliculasMenor5(Long generoId);

  public List<GetPeliculasMayor18OutOutputSQLResultDataDto> executeGetPeliculasMayor18(
      Long generoId);

  public List<GetSeriesMenor5OutOutputSQLResultDataDto> executeGetSeriesMenor5();

  public List<GetSeriesMenor5Hasta18OutOutputSQLResultDataDto> executeGetSeriesMenor5Hasta18();

  public List<GetSeriesMayor18OutOutputSQLResultDataDto> executeGetSeriesMayor18();

  public void executeAddUsuario(String nombre, String apellidos, Integer edad, String username);

  public void executeAddTitulo(
      Integer adult,
      Integer valoracion,
      Integer baby,
      Integer pelicula,
      Integer medium,
      String titulo,
      Long generoId);

  public List<GetTitulosOutOutputSQLResultDataDto> executeGetTitulos();

  public List<GetUsuariosOutUsuariosDataDto> executeGetUsuarios();

  public void executeDeleteUsuarioTrans(Long id);

  public void executeAddUsuarioTrans(String username);

  public GetUsuarioTransOutOutputSQLResultDto executeGetUsuarioTrans(String username);

  public void executeSavePrice(BigDecimal price, String currency, Long productId);

  public List<ShowProductsOutProductsDataDto> executeShowProducts(Long typeId);

  public List<GetGenerosOutOutputSQLResultDataDto> executeGetGeneros();

  public void executeDeleteUsuario(Long id);

  public void executeDeleteTitulo(Long id);

  public void executeDeleteProduct(Long id);

  public List<GetTypesOutTypesDataDto> executeGetTypes();

  public void executeAddType(String name);

  public GetTypeOutTypeDto executeGetType(Long typeId);

  public void executeValidateObjects(ValidateObjectsInUserDto user);

  public void executeDeleteValidateTypes();

  public void executeDeleteValidateObjects();

  public void executeDeleteValidateList();

  public void executeDeleteType(Long id);

  public void executeDeleteUsuarioTransByName(String username);

  public void executeAddValidName(String name);

  public void executeDeleteNames();

  public List<String> executeGetListUsuarios();

  public void executeInsertTypeProductTest();

  public void executeDeleteGeneroTest();

  public void executeDeleteTypeProductTest();

  public void executeDeleteTitulosTest();

  public void executeDeleteProductTest();

  public void executeDeleteUserTest();

  public void executeDeleteUsuarioTransTest();

  public void executeInsertUsuarioTest();

  public void executeInsertUsertTest();

  public void executeInsertUsuarioTransTest();

  public void executeInsertTitulosTest();
}
