package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.AddUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.UpdateUserCRUDBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cruds")
public interface UserCRUDProxy {

  @RequestMapping(value = "/UserCRUD/getUser/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> getUser(@PathVariable(name = "id", required = true) Long id);

  @RequestMapping(
      value = "/UserCRUD/deleteUserCrud",
      method = RequestMethod.DELETE,
      consumes = "application/json")
  public ResponseEntity<?> deleteUserCrud(
      @RequestBody DeleteUserCrudCRUDBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/UserCRUD/addUserCrud",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> addUserCrud(@RequestBody AddUserCrudCRUDBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/UserCRUD/updateUser",
      method = RequestMethod.PUT,
      consumes = "application/json")
  public ResponseEntity<?> updateUser(@RequestBody UpdateUserCRUDBodyRequestDto bodyRequest);

  @RequestMapping(value = "/UserCRUD/getAllUsers", method = RequestMethod.GET)
  public ResponseEntity<?> getAllUsers();
}
