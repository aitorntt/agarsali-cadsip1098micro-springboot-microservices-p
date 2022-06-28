package com.dedalow.cad.micro.services.impl;

import com.dedalow.cad.micro.commons.model.User;
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

  @Override
  @Transactional("internalTransactionManager")
  public User executeGetUser(Long id) {
    Optional<com.dedalow.cad.micro.domain.internal.User> userEntityOp =
        userCRUDRepository.findById(id);
    if (userEntityOp.isPresent()) {
      com.dedalow.cad.micro.domain.internal.User userEntity = userEntityOp.get();
      return UserEntityConverter.convertToModelWithRelations(userEntity);
    } else {
      return null;
    }
  }

  @Override
  @Transactional("internalTransactionManager")
  public void executeDeleteUserCrud(Long id) {
    userCRUDRepository.deleteById(id);
  }

  @Override
  @Transactional("internalTransactionManager")
  public List<com.dedalow.cad.micro.commons.model.User> executeGetAllUsers() {
    List<com.dedalow.cad.micro.domain.internal.User> userEntity = userCRUDRepository.findAll();
    return UserEntityConverter.convertToModelWithRelations(userEntity);
  }

  @Override
  @Transactional("internalTransactionManager")
  public User executeAddUserCrud(User inputDomain) {
    com.dedalow.cad.micro.domain.internal.User inputDomainEntity =
        UserEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = userCRUDRepository.save(inputDomainEntity);
    return UserEntityConverter.convertToModelWithRelations(inputDomainEntity);
  }

  @Override
  @Transactional("internalTransactionManager")
  public User executeUpdateUser(Long id, User inputDomain) {
    inputDomain.setId(id);
    com.dedalow.cad.micro.domain.internal.User inputDomainEntity =
        UserEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = userCRUDRepository.save(inputDomainEntity);
    return UserEntityConverter.convertToModelWithRelations(inputDomainEntity);
  }

  @Override
  @Transactional("internalTransactionManager")
  public long countAll() {
    long queryTotal = userCRUDRepository.count();

    return queryTotal;
  }
}
