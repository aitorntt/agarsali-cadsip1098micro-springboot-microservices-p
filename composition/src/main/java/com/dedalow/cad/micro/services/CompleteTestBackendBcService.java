package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;

public interface CompleteTestBackendBcService {

  public BackendResponse<?> executeCustomsAndRest(String username) throws CadException;

  public BackendResponse<?> executeCompleteBackendExample(String username) throws CadException;

  public BackendResponse<?> executeAddUser(String username) throws CadException;

  public BackendResponse<?> executeCruds(Long id) throws CadException;
}
