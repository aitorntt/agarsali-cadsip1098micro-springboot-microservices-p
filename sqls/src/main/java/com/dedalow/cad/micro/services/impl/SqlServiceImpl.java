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
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.EmptyResponse;
import com.dedalow.cad.micro.commons.dto.response.ForceFailOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetGenerosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetIdByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetListUsuariosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasAllOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetPeliculasMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMayor18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5Hasta18OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetSeriesMenor5OkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTitulosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTypeOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetTypesOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserByUsernameOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuarioTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuariosOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUsuariosTransOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.ShowProductsOkResponseResponseDto;
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
  public BackendResponse<?> executeDeleteUsuarioTest() {
    deleteUsuarioTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetPeliculasMenor5Hasta18(Long generoId) {
    List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> result =
        (getPeliculasMenor5Hasta18Repository.executeQuery(generoId));
    return BackendResponse.builder()
        .body(
            GetPeliculasMenor5Hasta18OkResponseResponseDto.builder()
                .outputSQLResult(result)
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeForceFail(String username) {
    List<ForceFailOutOutputSQLResultDataDto> result = (forceFailRepository.executeQuery(username));
    return BackendResponse.builder()
        .body(ForceFailOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeValidateList(Integer price) {
    validateListRepository.executeQuery(price);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeValidateTypes(
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
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetUsuariosTrans() {
    List<GetUsuariosTransOutOutputSQLResultDataDto> result =
        (getUsuariosTransRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetUsuariosTransOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeInsertProductTest() {
    insertProductTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetUserByUsername(String username) {
    GetUserByUsernameOutOutputSQLResultDto result =
        (getUserByUsernameRepository.executeQuery(username));
    return BackendResponse.builder()
        .body(GetUserByUsernameOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeInsertGeneroTest() {
    insertGeneroTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeInsertUser(String username) {
    insertUserRepository.executeQuery(username);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteUser(String username) {
    deleteUserRepository.executeQuery(username);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetIdByUsername(String username) {
    GetIdByUsernameOutOutputSQLResultDto result =
        (getIdByUsernameRepository.executeQuery(username));
    return BackendResponse.builder()
        .body(GetIdByUsernameOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetUsuario(String username) {
    GetUsuarioOutOutputSQLResultDto result = (getUsuarioRepository.executeQuery(username));
    return BackendResponse.builder()
        .body(GetUsuarioOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetPeliculasAll(Long generoId) {
    List<GetPeliculasAllOutPeliculasAllDataDto> result =
        (getPeliculasAllRepository.executeQuery(generoId));
    return BackendResponse.builder()
        .body(GetPeliculasAllOkResponseResponseDto.builder().peliculasAll(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetPeliculasMenor5(Long generoId) {
    List<GetPeliculasMenor5OutOutputSQLResultDataDto> result =
        (getPeliculasMenor5Repository.executeQuery(generoId));
    return BackendResponse.builder()
        .body(GetPeliculasMenor5OkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetPeliculasMayor18(Long generoId) {
    List<GetPeliculasMayor18OutOutputSQLResultDataDto> result =
        (getPeliculasMayor18Repository.executeQuery(generoId));
    return BackendResponse.builder()
        .body(GetPeliculasMayor18OkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetSeriesMenor5() {
    List<GetSeriesMenor5OutOutputSQLResultDataDto> result =
        (getSeriesMenor5Repository.executeQuery());
    return BackendResponse.builder()
        .body(GetSeriesMenor5OkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetSeriesMenor5Hasta18() {
    List<GetSeriesMenor5Hasta18OutOutputSQLResultDataDto> result =
        (getSeriesMenor5Hasta18Repository.executeQuery());
    return BackendResponse.builder()
        .body(GetSeriesMenor5Hasta18OkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetSeriesMayor18() {
    List<GetSeriesMayor18OutOutputSQLResultDataDto> result =
        (getSeriesMayor18Repository.executeQuery());
    return BackendResponse.builder()
        .body(GetSeriesMayor18OkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeAddUsuario(
      String nombre, String apellidos, Integer edad, String username) {
    addUsuarioRepository.executeQuery(nombre, apellidos, edad, username);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeAddTitulo(
      Integer adult,
      Integer valoracion,
      Integer baby,
      Integer pelicula,
      Integer medium,
      String titulo,
      Long generoId) {
    addTituloRepository.executeQuery(adult, valoracion, baby, pelicula, medium, titulo, generoId);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetTitulos() {
    List<GetTitulosOutOutputSQLResultDataDto> result = (getTitulosRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetTitulosOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetUsuarios() {
    List<GetUsuariosOutUsuariosDataDto> result = (getUsuariosRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetUsuariosOkResponseResponseDto.builder().usuarios(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeDeleteUsuarioTrans(Long id) {
    deleteUsuarioTransRepository.executeQuery(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeAddUsuarioTrans(String username) {
    addUsuarioTransRepository.executeQuery(username);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetUsuarioTrans(String username) {
    GetUsuarioTransOutOutputSQLResultDto result =
        (getUsuarioTransRepository.executeQuery(username));
    return BackendResponse.builder()
        .body(GetUsuarioTransOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeSavePrice(BigDecimal price, String currency, Long productId) {
    savePriceRepository.executeQuery(price, currency, productId);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeShowProducts(Long typeId) {
    List<ShowProductsOutProductsDataDto> result = (showProductsRepository.executeQuery(typeId));
    return BackendResponse.builder()
        .body(ShowProductsOkResponseResponseDto.builder().products(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeGetGeneros() {
    List<GetGenerosOutOutputSQLResultDataDto> result = (getGenerosRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetGenerosOkResponseResponseDto.builder().outputSQLResult(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeDeleteUsuario(Long id) {
    deleteUsuarioRepository.executeQuery(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteTitulo(Long id) {
    deleteTituloRepository.executeQuery(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteProduct(Long id) {
    deleteProductRepository.executeQuery(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetTypes() {
    List<GetTypesOutTypesDataDto> result = (getTypesRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetTypesOkResponseResponseDto.builder().types(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeAddType(String name) {
    addTypeRepository.executeQuery(name);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetType(Long typeId) {
    GetTypeOutTypeDto result = (getTypeRepository.executeQuery(typeId));
    return BackendResponse.builder()
        .body(GetTypeOkResponseResponseDto.builder().type(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeValidateObjects(ValidateObjectsInUserDto user) {
    validateObjectsRepository.executeQuery(user);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteValidateTypes() {
    deleteValidateTypesRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteValidateObjects() {
    deleteValidateObjectsRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteValidateList() {
    deleteValidateListRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteType(Long id) {
    deleteTypeRepository.executeQuery(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteUsuarioTransByName(String username) {
    deleteUsuarioTransByNameRepository.executeQuery(username);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeAddValidName(String name) {
    addValidNameRepository.executeQuery(name);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteNames() {
    deleteNamesRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeGetListUsuarios() {
    List<String> result = (getListUsuariosRepository.executeQuery());
    return BackendResponse.builder()
        .body(GetListUsuariosOkResponseResponseDto.builder().usuarios(result).build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  public BackendResponse<?> executeInsertTypeProductTest() {
    insertTypeProductTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteGeneroTest() {
    deleteGeneroTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteTypeProductTest() {
    deleteTypeProductTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteTitulosTest() {
    deleteTitulosTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteProductTest() {
    deleteProductTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteUserTest() {
    deleteUserTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeDeleteUsuarioTransTest() {
    deleteUsuarioTransTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeInsertUsuarioTest() {
    insertUsuarioTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeInsertUsertTest() {
    insertUsertTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeInsertUsuarioTransTest() {
    insertUsuarioTransTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  public BackendResponse<?> executeInsertTitulosTest() {
    insertTitulosTestRepository.executeQuery();
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }
}
