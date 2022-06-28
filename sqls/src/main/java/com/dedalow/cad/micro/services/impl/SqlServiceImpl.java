package com.dedalow.cad.micro.services.impl;

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
import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.repository.internal.AddTituloRepository;
import com.dedalow.cad.micro.repository.internal.AddTypeRepository;
import com.dedalow.cad.micro.repository.internal.AddUsuarioRepository;
import com.dedalow.cad.micro.repository.internal.AddUsuarioTransRepository;
import com.dedalow.cad.micro.repository.internal.AddValidNameRepository;
import com.dedalow.cad.micro.repository.internal.DeleteGeneroTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteNamesRepository;
import com.dedalow.cad.micro.repository.internal.DeleteProductRepository;
import com.dedalow.cad.micro.repository.internal.DeleteProductTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteTituloRepository;
import com.dedalow.cad.micro.repository.internal.DeleteTitulosTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteTypeProductTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteTypeRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUserRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUserTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUsuarioRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUsuarioTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUsuarioTransByNameRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUsuarioTransRepository;
import com.dedalow.cad.micro.repository.internal.DeleteUsuarioTransTestRepository;
import com.dedalow.cad.micro.repository.internal.DeleteValidateListRepository;
import com.dedalow.cad.micro.repository.internal.DeleteValidateObjectsRepository;
import com.dedalow.cad.micro.repository.internal.DeleteValidateTypesRepository;
import com.dedalow.cad.micro.repository.internal.ForceFailRepository;
import com.dedalow.cad.micro.repository.internal.GetGenerosRepository;
import com.dedalow.cad.micro.repository.internal.GetIdByUsernameRepository;
import com.dedalow.cad.micro.repository.internal.GetListUsuariosRepository;
import com.dedalow.cad.micro.repository.internal.GetPeliculasAllRepository;
import com.dedalow.cad.micro.repository.internal.GetPeliculasMayor18Repository;
import com.dedalow.cad.micro.repository.internal.GetPeliculasMenor5Hasta18Repository;
import com.dedalow.cad.micro.repository.internal.GetPeliculasMenor5Repository;
import com.dedalow.cad.micro.repository.internal.GetSeriesMayor18Repository;
import com.dedalow.cad.micro.repository.internal.GetSeriesMenor5Hasta18Repository;
import com.dedalow.cad.micro.repository.internal.GetSeriesMenor5Repository;
import com.dedalow.cad.micro.repository.internal.GetTitulosRepository;
import com.dedalow.cad.micro.repository.internal.GetTypeRepository;
import com.dedalow.cad.micro.repository.internal.GetTypesRepository;
import com.dedalow.cad.micro.repository.internal.GetUserByUsernameRepository;
import com.dedalow.cad.micro.repository.internal.GetUsuarioRepository;
import com.dedalow.cad.micro.repository.internal.GetUsuarioTransRepository;
import com.dedalow.cad.micro.repository.internal.GetUsuariosRepository;
import com.dedalow.cad.micro.repository.internal.GetUsuariosTransRepository;
import com.dedalow.cad.micro.repository.internal.InsertGeneroTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertProductTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertTitulosTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertTypeProductTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertUserRepository;
import com.dedalow.cad.micro.repository.internal.InsertUsertTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertUsuarioTestRepository;
import com.dedalow.cad.micro.repository.internal.InsertUsuarioTransTestRepository;
import com.dedalow.cad.micro.repository.internal.SavePriceRepository;
import com.dedalow.cad.micro.repository.internal.ShowProductsRepository;
import com.dedalow.cad.micro.repository.internal.ValidateListRepository;
import com.dedalow.cad.micro.repository.internal.ValidateObjectsRepository;
import com.dedalow.cad.micro.repository.internal.ValidateTypesRepository;
import com.dedalow.cad.micro.services.SqlService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlServiceImpl implements SqlService {

  static final Logger logger = Logger.getLogger(SqlServiceImpl.class);

  @Autowired private DeleteUsuarioTestRepository deleteUsuarioTestRepository;
  @Autowired private GetPeliculasMenor5Hasta18Repository getPeliculasMenor5Hasta18Repository;
  @Autowired private ForceFailRepository forceFailRepository;
  @Autowired private ValidateListRepository validateListRepository;
  @Autowired private ValidateTypesRepository validateTypesRepository;
  @Autowired private GetUsuariosTransRepository getUsuariosTransRepository;
  @Autowired private InsertProductTestRepository insertProductTestRepository;
  @Autowired private GetUserByUsernameRepository getUserByUsernameRepository;
  @Autowired private InsertGeneroTestRepository insertGeneroTestRepository;
  @Autowired private InsertUserRepository insertUserRepository;
  @Autowired private DeleteUserRepository deleteUserRepository;
  @Autowired private GetIdByUsernameRepository getIdByUsernameRepository;
  @Autowired private GetUsuarioRepository getUsuarioRepository;
  @Autowired private GetPeliculasAllRepository getPeliculasAllRepository;
  @Autowired private GetPeliculasMenor5Repository getPeliculasMenor5Repository;
  @Autowired private GetPeliculasMayor18Repository getPeliculasMayor18Repository;
  @Autowired private GetSeriesMenor5Repository getSeriesMenor5Repository;
  @Autowired private GetSeriesMenor5Hasta18Repository getSeriesMenor5Hasta18Repository;
  @Autowired private GetSeriesMayor18Repository getSeriesMayor18Repository;
  @Autowired private AddUsuarioRepository addUsuarioRepository;
  @Autowired private AddTituloRepository addTituloRepository;
  @Autowired private GetTitulosRepository getTitulosRepository;
  @Autowired private GetUsuariosRepository getUsuariosRepository;
  @Autowired private DeleteUsuarioTransRepository deleteUsuarioTransRepository;
  @Autowired private AddUsuarioTransRepository addUsuarioTransRepository;
  @Autowired private GetUsuarioTransRepository getUsuarioTransRepository;
  @Autowired private SavePriceRepository savePriceRepository;
  @Autowired private ShowProductsRepository showProductsRepository;
  @Autowired private GetGenerosRepository getGenerosRepository;
  @Autowired private DeleteUsuarioRepository deleteUsuarioRepository;
  @Autowired private DeleteTituloRepository deleteTituloRepository;
  @Autowired private DeleteProductRepository deleteProductRepository;
  @Autowired private GetTypesRepository getTypesRepository;
  @Autowired private AddTypeRepository addTypeRepository;
  @Autowired private GetTypeRepository getTypeRepository;
  @Autowired private ValidateObjectsRepository validateObjectsRepository;
  @Autowired private DeleteValidateTypesRepository deleteValidateTypesRepository;
  @Autowired private DeleteValidateObjectsRepository deleteValidateObjectsRepository;
  @Autowired private DeleteValidateListRepository deleteValidateListRepository;
  @Autowired private DeleteTypeRepository deleteTypeRepository;
  @Autowired private DeleteUsuarioTransByNameRepository deleteUsuarioTransByNameRepository;
  @Autowired private AddValidNameRepository addValidNameRepository;
  @Autowired private DeleteNamesRepository deleteNamesRepository;
  @Autowired private GetListUsuariosRepository getListUsuariosRepository;
  @Autowired private InsertTypeProductTestRepository insertTypeProductTestRepository;
  @Autowired private DeleteGeneroTestRepository deleteGeneroTestRepository;
  @Autowired private DeleteTypeProductTestRepository deleteTypeProductTestRepository;
  @Autowired private DeleteTitulosTestRepository deleteTitulosTestRepository;
  @Autowired private DeleteProductTestRepository deleteProductTestRepository;
  @Autowired private DeleteUserTestRepository deleteUserTestRepository;
  @Autowired private DeleteUsuarioTransTestRepository deleteUsuarioTransTestRepository;
  @Autowired private InsertUsuarioTestRepository insertUsuarioTestRepository;
  @Autowired private InsertUsertTestRepository insertUsertTestRepository;
  @Autowired private InsertUsuarioTransTestRepository insertUsuarioTransTestRepository;
  @Autowired private InsertTitulosTestRepository insertTitulosTestRepository;

  @Autowired EncodeService encodeService;

  @Override
  public void executeDeleteUsuarioTest() {
    deleteUsuarioTestRepository.executeQuery();
  }

  @Override
  public List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> executeGetPeliculasMenor5Hasta18(
      Long generoId) {
    List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> result =
        (getPeliculasMenor5Hasta18Repository.executeQuery(generoId));
    return result;
  }

  @Override
  public List<ForceFailOutOutputSQLResultDataDto> executeForceFail(String username) {
    List<ForceFailOutOutputSQLResultDataDto> result = (forceFailRepository.executeQuery(username));
    return result;
  }

  @Override
  public void executeValidateList(Integer price) {
    validateListRepository.executeQuery(price);
  }

  @Override
  public void executeValidateTypes(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString) {
    if (Objects.nonNull(typePassword)) {
      typePassword = encodeService.encode(typePassword);
    }
    validateTypesRepository.executeQuery(
        typeBoolean, typeDecimal, typeInteger, typeLong, typeLongText, typePassword, typeString);
  }

  @Override
  public List<GetUsuariosTransOutOutputSQLResultDataDto> executeGetUsuariosTrans() {
    List<GetUsuariosTransOutOutputSQLResultDataDto> result =
        (getUsuariosTransRepository.executeQuery());
    return result;
  }

  @Override
  public void executeInsertProductTest() {
    insertProductTestRepository.executeQuery();
  }

  @Override
  public GetUserByUsernameOutOutputSQLResultDto executeGetUserByUsername(String username) {
    GetUserByUsernameOutOutputSQLResultDto result =
        (getUserByUsernameRepository.executeQuery(username));
    return result;
  }

  @Override
  public void executeInsertGeneroTest() {
    insertGeneroTestRepository.executeQuery();
  }

  @Override
  public void executeInsertUser(String username) {
    insertUserRepository.executeQuery(username);
  }

  @Override
  public void executeDeleteUser(String username) {
    deleteUserRepository.executeQuery(username);
  }

  @Override
  public GetIdByUsernameOutOutputSQLResultDto executeGetIdByUsername(String username) {
    GetIdByUsernameOutOutputSQLResultDto result =
        (getIdByUsernameRepository.executeQuery(username));
    return result;
  }

  @Override
  public GetUsuarioOutOutputSQLResultDto executeGetUsuario(String username) {
    GetUsuarioOutOutputSQLResultDto result = (getUsuarioRepository.executeQuery(username));
    return result;
  }

  @Override
  public List<GetPeliculasAllOutPeliculasAllDataDto> executeGetPeliculasAll(Long generoId) {
    List<GetPeliculasAllOutPeliculasAllDataDto> result =
        (getPeliculasAllRepository.executeQuery(generoId));
    return result;
  }

  @Override
  public List<GetPeliculasMenor5OutOutputSQLResultDataDto> executeGetPeliculasMenor5(
      Long generoId) {
    List<GetPeliculasMenor5OutOutputSQLResultDataDto> result =
        (getPeliculasMenor5Repository.executeQuery(generoId));
    return result;
  }

  @Override
  public List<GetPeliculasMayor18OutOutputSQLResultDataDto> executeGetPeliculasMayor18(
      Long generoId) {
    List<GetPeliculasMayor18OutOutputSQLResultDataDto> result =
        (getPeliculasMayor18Repository.executeQuery(generoId));
    return result;
  }

  @Override
  public List<GetSeriesMenor5OutOutputSQLResultDataDto> executeGetSeriesMenor5() {
    List<GetSeriesMenor5OutOutputSQLResultDataDto> result =
        (getSeriesMenor5Repository.executeQuery());
    return result;
  }

  @Override
  public List<GetSeriesMenor5Hasta18OutOutputSQLResultDataDto> executeGetSeriesMenor5Hasta18() {
    List<GetSeriesMenor5Hasta18OutOutputSQLResultDataDto> result =
        (getSeriesMenor5Hasta18Repository.executeQuery());
    return result;
  }

  @Override
  public List<GetSeriesMayor18OutOutputSQLResultDataDto> executeGetSeriesMayor18() {
    List<GetSeriesMayor18OutOutputSQLResultDataDto> result =
        (getSeriesMayor18Repository.executeQuery());
    return result;
  }

  @Override
  public void executeAddUsuario(String nombre, String apellidos, Integer edad, String username) {
    addUsuarioRepository.executeQuery(nombre, apellidos, edad, username);
  }

  @Override
  public void executeAddTitulo(
      Integer adult,
      Integer valoracion,
      Integer baby,
      Integer pelicula,
      Integer medium,
      String titulo,
      Long generoId) {
    addTituloRepository.executeQuery(adult, valoracion, baby, pelicula, medium, titulo, generoId);
  }

  @Override
  public List<GetTitulosOutOutputSQLResultDataDto> executeGetTitulos() {
    List<GetTitulosOutOutputSQLResultDataDto> result = (getTitulosRepository.executeQuery());
    return result;
  }

  @Override
  public List<GetUsuariosOutUsuariosDataDto> executeGetUsuarios() {
    List<GetUsuariosOutUsuariosDataDto> result = (getUsuariosRepository.executeQuery());
    return result;
  }

  @Override
  public void executeDeleteUsuarioTrans(Long id) {
    deleteUsuarioTransRepository.executeQuery(id);
  }

  @Override
  public void executeAddUsuarioTrans(String username) {
    addUsuarioTransRepository.executeQuery(username);
  }

  @Override
  public GetUsuarioTransOutOutputSQLResultDto executeGetUsuarioTrans(String username) {
    GetUsuarioTransOutOutputSQLResultDto result =
        (getUsuarioTransRepository.executeQuery(username));
    return result;
  }

  @Override
  public void executeSavePrice(BigDecimal price, String currency, Long productId) {
    savePriceRepository.executeQuery(price, currency, productId);
  }

  @Override
  public List<ShowProductsOutProductsDataDto> executeShowProducts(Long typeId) {
    List<ShowProductsOutProductsDataDto> result = (showProductsRepository.executeQuery(typeId));
    return result;
  }

  @Override
  public List<GetGenerosOutOutputSQLResultDataDto> executeGetGeneros() {
    List<GetGenerosOutOutputSQLResultDataDto> result = (getGenerosRepository.executeQuery());
    return result;
  }

  @Override
  public void executeDeleteUsuario(Long id) {
    deleteUsuarioRepository.executeQuery(id);
  }

  @Override
  public void executeDeleteTitulo(Long id) {
    deleteTituloRepository.executeQuery(id);
  }

  @Override
  public void executeDeleteProduct(Long id) {
    deleteProductRepository.executeQuery(id);
  }

  @Override
  public List<GetTypesOutTypesDataDto> executeGetTypes() {
    List<GetTypesOutTypesDataDto> result = (getTypesRepository.executeQuery());
    return result;
  }

  @Override
  public void executeAddType(String name) {
    addTypeRepository.executeQuery(name);
  }

  @Override
  public GetTypeOutTypeDto executeGetType(Long typeId) {
    GetTypeOutTypeDto result = (getTypeRepository.executeQuery(typeId));
    return result;
  }

  @Override
  public void executeValidateObjects(ValidateObjectsInUserDto user) {
    validateObjectsRepository.executeQuery(user);
  }

  @Override
  public void executeDeleteValidateTypes() {
    deleteValidateTypesRepository.executeQuery();
  }

  @Override
  public void executeDeleteValidateObjects() {
    deleteValidateObjectsRepository.executeQuery();
  }

  @Override
  public void executeDeleteValidateList() {
    deleteValidateListRepository.executeQuery();
  }

  @Override
  public void executeDeleteType(Long id) {
    deleteTypeRepository.executeQuery(id);
  }

  @Override
  public void executeDeleteUsuarioTransByName(String username) {
    deleteUsuarioTransByNameRepository.executeQuery(username);
  }

  @Override
  public void executeAddValidName(String name) {
    addValidNameRepository.executeQuery(name);
  }

  @Override
  public void executeDeleteNames() {
    deleteNamesRepository.executeQuery();
  }

  @Override
  public List<String> executeGetListUsuarios() {
    List<String> result = (getListUsuariosRepository.executeQuery());
    return result;
  }

  @Override
  public void executeInsertTypeProductTest() {
    insertTypeProductTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteGeneroTest() {
    deleteGeneroTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteTypeProductTest() {
    deleteTypeProductTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteTitulosTest() {
    deleteTitulosTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteProductTest() {
    deleteProductTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteUserTest() {
    deleteUserTestRepository.executeQuery();
  }

  @Override
  public void executeDeleteUsuarioTransTest() {
    deleteUsuarioTransTestRepository.executeQuery();
  }

  @Override
  public void executeInsertUsuarioTest() {
    insertUsuarioTestRepository.executeQuery();
  }

  @Override
  public void executeInsertUsertTest() {
    insertUsertTestRepository.executeQuery();
  }

  @Override
  public void executeInsertUsuarioTransTest() {
    insertUsuarioTransTestRepository.executeQuery();
  }

  @Override
  public void executeInsertTitulosTest() {
    insertTitulosTestRepository.executeQuery();
  }
}
