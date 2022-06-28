package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;

public interface TestingConditionalLoopBcService {

  public BackendResponse<?> executeTestingConditionalLoop(String username) throws CadException;
}
