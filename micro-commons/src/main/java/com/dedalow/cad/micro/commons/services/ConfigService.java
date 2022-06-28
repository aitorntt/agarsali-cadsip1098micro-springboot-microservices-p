package com.dedalow.cad.micro.commons.services;

import com.dedalow.cad.micro.commons.exception.ExceptionResponse;

public interface ConfigService {

  ExceptionResponse selectedException(Exception exc, String type);
}
