package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;

public interface LoadDataBcService {

  public BackendResponse<?> executeLoadDatabase() throws CadException;
}
