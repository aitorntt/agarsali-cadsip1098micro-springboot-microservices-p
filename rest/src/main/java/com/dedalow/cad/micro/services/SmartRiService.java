package com.dedalow.cad.micro.services;



import com.dedalow.cad.micro.commons.dto.response.BackendResponse;

public interface SmartRiService {

  public BackendResponse<?> executeLogin(String username, String password) throws Exception;

  public BackendResponse<?> executeLogin(String username, String password, boolean sslVerification)
      throws Exception;

  public BackendResponse<?> executeUserDetail(String authorization, String username)
      throws Exception;

  public BackendResponse<?> executeUserDetail(
      String authorization, String username, boolean sslVerification) throws Exception;
}
