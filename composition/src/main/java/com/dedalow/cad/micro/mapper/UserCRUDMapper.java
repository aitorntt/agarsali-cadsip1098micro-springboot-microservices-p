package com.dedalow.cad.micro.mapper;


import com.dedalow.cad.micro.commons.dto.request.AddUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.UpdateUserCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.proxy.UserCRUDProxy;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserCRUDMapper {

  @Autowired UserCRUDProxy userCRUDProxy;

  public BackendResponse<?> executeGetUser(Long id) throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = userCRUDProxy.getUser(id);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeDeleteUserCrud(Long id) throws CadException {

    DeleteUserCrudCRUDBodyRequestDto bodyInput =
        DeleteUserCrudCRUDBodyRequestDto.builder().id(id).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = userCRUDProxy.deleteUserCrud(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeAddUserCrud(User inputDomain) throws CadException {

    AddUserCrudCRUDBodyRequestDto bodyInput =
        AddUserCrudCRUDBodyRequestDto.builder().inputDomain(inputDomain).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = userCRUDProxy.addUserCrud(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeUpdateUser(Long id, User inputDomain) throws CadException {

    UpdateUserCRUDBodyRequestDto bodyInput =
        UpdateUserCRUDBodyRequestDto.builder().id(id).inputDomain(inputDomain).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = userCRUDProxy.updateUser(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }

  public BackendResponse<?> executeGetAllUsers() throws CadException {

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = userCRUDProxy.getAllUsers();

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }
}
