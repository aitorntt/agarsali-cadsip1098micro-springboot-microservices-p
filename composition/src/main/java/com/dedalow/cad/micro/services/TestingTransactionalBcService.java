package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;

public interface TestingTransactionalBcService {

  public BackendResponse<?> executeRetTransactional(String username) throws CadException;

  public BackendResponse<?> executeTestingTransactional(String username) throws CadException;
}
