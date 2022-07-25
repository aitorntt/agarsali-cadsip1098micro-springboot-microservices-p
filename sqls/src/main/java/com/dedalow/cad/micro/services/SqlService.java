package com.dedalow.cad.micro.services;





import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import java.math.BigDecimal;

public interface SqlService {
  public BackendResponse<?> executeDeleteUsuarioTest();

  public BackendResponse<?> executeGetPeliculasMenor5Hasta18(Long generoId);

  public BackendResponse<?> executeForceFail(String username);

  public BackendResponse<?> executeValidateList(Integer price);

  public BackendResponse<?> executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString);

  public BackendResponse<?> executeGetUsuariosTrans();

  public BackendResponse<?> executeInsertProductTest();

  public BackendResponse<?> executeGetUserByUsername(String username);

  public BackendResponse<?> executeInsertGeneroTest();

  public BackendResponse<?> executeInsertUser(String username);

  public BackendResponse<?> executeDeleteUser(String username);

  public BackendResponse<?> executeGetIdByUsername(String username);

  public BackendResponse<?> executeGetUsuario(String username);

  public BackendResponse<?> executeGetPeliculasAll(Long generoId);

  public BackendResponse<?> executeGetPeliculasMenor5(Long generoId);

  public BackendResponse<?> executeGetPeliculasMayor18(Long generoId);

  public BackendResponse<?> executeGetSeriesMenor5();

  public BackendResponse<?> executeGetSeriesMenor5Hasta18();

  public BackendResponse<?> executeGetSeriesMayor18();

  public BackendResponse<?> executeAddUsuario(
      String nombre, String apellidos, Integer edad, String username);

  public BackendResponse<?> executeAddTitulo(
      Integer adult,
      Integer valoracion,
      Integer baby,
      Integer pelicula,
      Integer medium,
      String titulo,
      Long generoId);

  public BackendResponse<?> executeGetTitulos();

  public BackendResponse<?> executeGetUsuarios();

  public BackendResponse<?> executeDeleteUsuarioTrans(Long id);

  public BackendResponse<?> executeAddUsuarioTrans(String username);

  public BackendResponse<?> executeGetUsuarioTrans(String username);

  public BackendResponse<?> executeSavePrice(BigDecimal price, String currency, Long productId);

  public BackendResponse<?> executeShowProducts(Long typeId);

  public BackendResponse<?> executeGetGeneros();

  public BackendResponse<?> executeDeleteUsuario(Long id);

  public BackendResponse<?> executeDeleteTitulo(Long id);

  public BackendResponse<?> executeDeleteProduct(Long id);

  public BackendResponse<?> executeGetTypes();

  public BackendResponse<?> executeAddType(String name);

  public BackendResponse<?> executeGetType(Long typeId);

  public BackendResponse<?> executeValidateObjects(ValidateObjectsInUserDto user);

  public BackendResponse<?> executeDeleteValidateTypes();

  public BackendResponse<?> executeDeleteValidateObjects();

  public BackendResponse<?> executeDeleteValidateList();

  public BackendResponse<?> executeDeleteType(Long id);

  public BackendResponse<?> executeDeleteUsuarioTransByName(String username);

  public BackendResponse<?> executeAddValidName(String name);

  public BackendResponse<?> executeDeleteNames();

  public BackendResponse<?> executeGetListUsuarios();

  public BackendResponse<?> executeInsertTypeProductTest();

  public BackendResponse<?> executeDeleteGeneroTest();

  public BackendResponse<?> executeDeleteTypeProductTest();

  public BackendResponse<?> executeDeleteTitulosTest();

  public BackendResponse<?> executeDeleteProductTest();

  public BackendResponse<?> executeDeleteUserTest();

  public BackendResponse<?> executeDeleteUsuarioTransTest();

  public BackendResponse<?> executeInsertUsuarioTest();

  public BackendResponse<?> executeInsertUsertTest();

  public BackendResponse<?> executeInsertUsuarioTransTest();

  public BackendResponse<?> executeInsertTitulosTest();
}
