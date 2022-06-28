package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.model.User;
import java.util.List;

public interface UserCRUDService {

  public User executeGetUser(Long id);

  public User executeUpdateUser(Long id, User inputDomain);

  public void executeDeleteUserCrud(Long id);

  public List<com.dedalow.cad.micro.commons.model.User> executeGetAllUsers();

  public User executeAddUserCrud(User inputDomain);

  long countAll();
}
