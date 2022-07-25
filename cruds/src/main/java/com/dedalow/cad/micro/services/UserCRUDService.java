package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.model.User;

public interface UserCRUDService {

  public BackendResponse<?> executeDeleteUserCrud(Long id);

  public BackendResponse<?> executeGetAllUsers();

  public BackendResponse<?> executeAddUserCrud(User inputDomain);

  public BackendResponse<?> executeUpdateUser(Long id, User inputDomain);

  public BackendResponse<?> executeGetUser(Long id);

  long countAll();
}
