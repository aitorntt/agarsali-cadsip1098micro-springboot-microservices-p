package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.AddUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.DeleteUserCrudCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.GetUserCRUDPathVariableRequestDto;
import com.dedalow.cad.micro.commons.dto.request.UpdateUserCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.AddUserCrudCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetAllUsersCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.UpdateUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.repository.internal.UserCRUDRepository;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserCrudControllerTest {

  @LocalServerPort private int localPort;

  @Autowired UserTestConnection connect;
  @Autowired UserCRUDController userCRUDController;

  public static final String URI = "/UserCRUD";

  @Test
  void findEntityGetUser() {
    Long id = connect.createEmptyEntity();

    GetUserCRUDPathVariableRequestDto pathVariableRequestDto =
        GetUserCRUDPathVariableRequestDto.builder().id(id).build();

    ResponseEntity<GetUserCRUDOkResponseResponseDto> response =
        (ResponseEntity<GetUserCRUDOkResponseResponseDto>)
            userCRUDController.getUser(pathVariableRequestDto);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertNotNull(response.getBody().getOutputDomainEntity());
  }

  @Test
  void updateEntityUpdateUser() {
    Long id = connect.createEmptyEntity();

    String username = "username";
    String password = "password";
    Integer edad = 1;
    UpdateUserCRUDBodyRequestDto bodyRequestDto =
        UpdateUserCRUDBodyRequestDto.builder()
            .id(id)
            .inputDomain(User.builder().username(username).password(password).edad(edad).build())
            .build();

    ResponseEntity<UpdateUserCRUDOkResponseResponseDto> response =
        (ResponseEntity<UpdateUserCRUDOkResponseResponseDto>)
            userCRUDController.updateUser(bodyRequestDto);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    User outputDomain = response.getBody().getOutputDomainEntity();
    Assertions.assertEquals(id, outputDomain.getId());
    Assertions.assertEquals(username, outputDomain.getUsername());
    Assertions.assertEquals(password, outputDomain.getPassword());
    Assertions.assertEquals(edad, outputDomain.getEdad());
  }

  @Test
  void deleteEntityDeleteUserCrud() {
    Long id = connect.createEmptyEntity();
    DeleteUserCrudCRUDBodyRequestDto bodyRequestDto =
        DeleteUserCrudCRUDBodyRequestDto.builder().id(id).build();

    ResponseEntity<?> response =
        (ResponseEntity<?>) userCRUDController.deleteUserCrud(bodyRequestDto);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void findAllGetAllUsers() {

    String username = "username";
    String password = "password";
    Integer edad = 1;
    ResponseEntity<GetAllUsersCRUDOkResponseResponseDto> response =
        (ResponseEntity<GetAllUsersCRUDOkResponseResponseDto>) userCRUDController.getAllUsers();
    IntStream.rangeClosed(1, 2).forEach(c -> connect.createEmptyEntity());

    ResponseEntity<GetAllUsersCRUDOkResponseResponseDto> newResponse =
        (ResponseEntity<GetAllUsersCRUDOkResponseResponseDto>) userCRUDController.getAllUsers();
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(
        response.getBody().getOutputDomainEntityList().size() + 2,
        newResponse.getBody().getOutputDomainEntityList().size());
  }

  @Test
  void createEntityAddUserCrud() {
    String username = "username";
    String password = "password";
    Integer edad = 1;
    AddUserCrudCRUDBodyRequestDto bodyRequestDto =
        AddUserCrudCRUDBodyRequestDto.builder()
            .inputDomain(User.builder().username(username).password(password).edad(edad).build())
            .build();

    ResponseEntity<AddUserCrudCRUDOkResponseResponseDto> response =
        (ResponseEntity<AddUserCrudCRUDOkResponseResponseDto>)
            userCRUDController.addUserCrud(bodyRequestDto);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}

@Service
@RequiredArgsConstructor
class UserTestConnection {

  @Autowired UserCRUDRepository userCRUDRepository;

  @Transactional("internalTransactionManager")
  public Long createEmptyEntity() {
    com.dedalow.cad.micro.domain.internal.User entity =
        new com.dedalow.cad.micro.domain.internal.User();
    String username = "username";
    entity.setUsername(username);
    String password = "password";
    entity.setPassword(password);
    Integer edad = 1;
    entity.setEdad(edad);
    entity = userCRUDRepository.save(entity);
    return entity.getId();
  }
}
