package com.dedalow.cad.micro.services;



import com.dedalow.cad.micro.commons.dto.response.BackendResponse;

public interface ValidateListRestRiService {

  public BackendResponse<?> executeGetList() throws Exception;

  public BackendResponse<?> executeGetList(boolean sslVerification) throws Exception;
}
