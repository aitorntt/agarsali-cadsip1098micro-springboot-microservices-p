package com.dedalow.cad.micro.mapper;

import com.dedalow.cad.micro.commons.dto.request.AddUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.UpdateUserCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.AddUserCrudCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetAllUsersCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.UpdateUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.proxy.UserCRUDProxy;
import com.fasterxml.jackson.core.type.TypeReference;
import feign.FeignException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserCRUDMapper {

  @Autowired UserCRUDProxy userCRUDProxy;

  public User executeGetUser(Long id) throws CadException {

    try {
      ResponseEntity<?> response = userCRUDProxy.getUser(id);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetUserCRUDOkResponseResponseDto>() {})
          .getOutputDomainEntity();
    } catch (FeignException e) {
      throw e;
    }
  }

  public void executeDeleteUserCrud(Long id) throws CadException {

    DeleteUserCrudCRUDBodyRequestDto bodyInput =
        DeleteUserCrudCRUDBodyRequestDto.builder().id(id).build();

    try {
      userCRUDProxy.deleteUserCrud(bodyInput);

    } catch (FeignException e) {
      throw e;
    }
  }

  public User executeAddUserCrud(User inputDomain) throws CadException {

    AddUserCrudCRUDBodyRequestDto bodyInput =
        AddUserCrudCRUDBodyRequestDto.builder().inputDomain(inputDomain).build();

    try {
      ResponseEntity<?> response = userCRUDProxy.addUserCrud(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<AddUserCrudCRUDOkResponseResponseDto>() {})
          .getOutputDomainEntity();
    } catch (FeignException e) {
      throw e;
    }
  }

  public User executeUpdateUser(Long id, User inputDomain) throws CadException {

    UpdateUserCRUDBodyRequestDto bodyInput =
        UpdateUserCRUDBodyRequestDto.builder().id(id).inputDomain(inputDomain).build();

    try {
      ResponseEntity<?> response = userCRUDProxy.updateUser(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<UpdateUserCRUDOkResponseResponseDto>() {})
          .getOutputDomainEntity();
    } catch (FeignException e) {
      throw e;
    }
  }

  public List<User> executeGetAllUsers() throws CadException {

    try {
      ResponseEntity<?> response = userCRUDProxy.getAllUsers();

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<GetAllUsersCRUDOkResponseResponseDto>() {})
          .getOutputDomainEntityList();
    } catch (FeignException e) {
      throw e;
    }
  }
}
