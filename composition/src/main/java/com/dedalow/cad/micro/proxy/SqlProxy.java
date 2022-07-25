package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.AddValidNameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUsuarioTransByNameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ForceFailBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetIdByUsernameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasAllBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMayor18BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMenor5BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetPeliculasMenor5Hasta18BodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetTypeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUserByUsernameBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUsuarioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUsuarioTransBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.InsertUserBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.SavePriceBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ShowProductsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateListBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateObjectsBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.ValidateTypesBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sqls")
public interface SqlProxy {

  @RequestMapping(value = "/insert-usuario-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsuarioTest();

  @RequestMapping(value = "/insert-titulos-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertTitulosTest();

  @RequestMapping(value = "/insert-genero-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertGeneroTest();

  @RequestMapping(value = "/insert-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertProductTest();

  @RequestMapping(value = "/insert-type-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertTypeProductTest();

  @RequestMapping(value = "/insert-usuario-trans-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsuarioTransTest();

  @RequestMapping(
      value = "/get-user-by-username",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getUserByUsername(
      @RequestBody GetUserByUsernameBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-id-by-username",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getIdByUsername(@RequestBody GetIdByUsernameBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/insert-user",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> insertUser(@RequestBody InsertUserBodyRequestDto bodyRequest);

  @RequestMapping(value = "/force-fail", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<?> forceFail(@RequestBody ForceFailBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-usuario-trans",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getUsuarioTrans(@RequestBody GetUsuarioTransBodyRequestDto bodyRequest);

  @RequestMapping(value = "/delete-validate-types", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateTypes();

  @RequestMapping(value = "/delete-validate-objects", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateObjects();

  @RequestMapping(value = "/delete-validate-list", method = RequestMethod.POST)
  public ResponseEntity<?> deleteValidateList();

  @RequestMapping(value = "/save-price", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<?> savePrice(@RequestBody SavePriceBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/add-valid-name",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> addValidName(@RequestBody AddValidNameBodyRequestDto bodyRequest);

  @RequestMapping(value = "/get-type", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<?> getType(@RequestBody GetTypeBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/show-products",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> showProducts(@RequestBody ShowProductsBodyRequestDto bodyRequest);

  @RequestMapping(value = "/delete-user-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUserTest();

  @RequestMapping(value = "/delete-usuario-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTest();

  @RequestMapping(value = "/delete-titulos-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteTitulosTest();

  @RequestMapping(value = "/delete-genero-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteGeneroTest();

  @RequestMapping(value = "/delete-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteProductTest();

  @RequestMapping(value = "/delete-type-product-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteTypeProductTest();

  @RequestMapping(value = "/delete-usuario-trans-test", method = RequestMethod.POST)
  public ResponseEntity<?> deleteUsuarioTransTest();

  @RequestMapping(
      value = "/delete-user",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> deleteUser(@RequestBody DeleteUserBodyRequestDto bodyRequest);

  @RequestMapping(value = "/insert-usert-test", method = RequestMethod.POST)
  public ResponseEntity<?> insertUsertTest();

  @RequestMapping(
      value = "/delete-usuario-trans-by-name",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> deleteUsuarioTransByName(
      @RequestBody DeleteUsuarioTransByNameBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-usuario",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getUsuario(@RequestBody GetUsuarioBodyRequestDto bodyRequest);

  @RequestMapping(value = "/get-generos", method = RequestMethod.POST)
  public ResponseEntity<?> getGeneros();

  @RequestMapping(
      value = "/get-peliculas-menor5",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getPeliculasMenor5(
      @RequestBody GetPeliculasMenor5BodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-peliculas-menor5-hasta18",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getPeliculasMenor5Hasta18(
      @RequestBody GetPeliculasMenor5Hasta18BodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-peliculas-mayor18",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getPeliculasMayor18(
      @RequestBody GetPeliculasMayor18BodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/get-peliculas-all",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> getPeliculasAll(@RequestBody GetPeliculasAllBodyRequestDto bodyRequest);

  @RequestMapping(value = "/get-series-menor5", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMenor5();

  @RequestMapping(value = "/get-series-menor5-hasta18", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMenor5Hasta18();

  @RequestMapping(value = "/get-series-mayor18", method = RequestMethod.POST)
  public ResponseEntity<?> getSeriesMayor18();

  @RequestMapping(
      value = "/validate-types",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> validateTypes(@RequestBody ValidateTypesBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/validate-objects",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> validateObjects(@RequestBody ValidateObjectsBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/validate-list",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> validateList(@RequestBody ValidateListBodyRequestDto bodyRequest);
}
