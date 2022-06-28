package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;

public interface TestingIncrementalConfigBcService {

  public BackendResponse<?> executeSumaPares() throws CadException;

  public BackendResponse<?> executeCountGeneros() throws CadException;
}
