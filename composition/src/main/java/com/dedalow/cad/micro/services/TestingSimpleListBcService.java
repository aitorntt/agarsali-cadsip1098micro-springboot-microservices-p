package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import java.util.List;

public interface TestingSimpleListBcService {

  public BackendResponse<?> executeTestSimpleList(Integer modValue, List<String> names)
      throws CadException;
}
