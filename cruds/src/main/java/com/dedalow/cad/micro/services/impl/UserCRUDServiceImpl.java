package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.dto.response.AddUserCrudCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.EmptyResponse;
import com.dedalow.cad.micro.commons.dto.response.GetAllUsersCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.GetUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.dto.response.UpdateUserCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.model.User;
import com.dedalow.cad.micro.commons.services.EncodeService;
import com.dedalow.cad.micro.domain.util.UserEntityConverter;
import com.dedalow.cad.micro.repository.internal.UserCRUDRepository;
import com.dedalow.cad.micro.services.UserCRUDService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCRUDServiceImpl implements UserCRUDService {

  static final Logger logger = Logger.getLogger(UserCRUDServiceImpl.class);

  @Autowired private UserCRUDRepository userCRUDRepository;

  @Autowired EncodeService encodeService;

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeDeleteUserCrud(Long id) {
    userCRUDRepository.deleteById(id);
    return BackendResponse.builder().body(new EmptyResponse()).isOk(true).statusCode(200).build();
  }

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeGetAllUsers() {
    List<com.dedalow.cad.micro.domain.internal.User> userEntity = userCRUDRepository.findAll();
    return BackendResponse.builder()
        .body(
            GetAllUsersCRUDOkResponseResponseDto.builder()
                .outputDomainEntityList(UserEntityConverter.convertToModelWithRelations(userEntity))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeAddUserCrud(User inputDomain) {
    com.dedalow.cad.micro.domain.internal.User inputDomainEntity =
        UserEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = userCRUDRepository.save(inputDomainEntity);
    return BackendResponse.builder()
        .body(
            AddUserCrudCRUDOkResponseResponseDto.builder()
                .outputDomainEntity(
                    UserEntityConverter.convertToModelWithRelations(inputDomainEntity))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeUpdateUser(Long id, User inputDomain) {
    inputDomain.setId(id);
    com.dedalow.cad.micro.domain.internal.User inputDomainEntity =
        UserEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = userCRUDRepository.save(inputDomainEntity);
    return BackendResponse.builder()
        .body(
            UpdateUserCRUDOkResponseResponseDto.builder()
                .outputDomainEntity(
                    UserEntityConverter.convertToModelWithRelations(inputDomainEntity))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeGetUser(Long id) {
    Optional<com.dedalow.cad.micro.domain.internal.User> userEntityOp =
        userCRUDRepository.findById(id);
    if (userEntityOp.isPresent()) {
      com.dedalow.cad.micro.domain.internal.User userEntity = userEntityOp.get();
      return BackendResponse.builder()
          .body(
              GetUserCRUDOkResponseResponseDto.builder()
                  .outputDomainEntity(UserEntityConverter.convertToModelWithRelations(userEntity))
                  .build())
          .isOk(true)
          .statusCode(200)
          .build();

    } else {
      return BackendResponse.builder().body(null).isOk(true).statusCode(200).build();
    }
  }

  @Override
  @Transactional("internalTransactionManager")
  public long countAll() {
    long queryTotal = userCRUDRepository.count();

    return queryTotal;
  }
}
