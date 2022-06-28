package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.SmartRiLoginBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rest")
public interface SmartRiProxy {

  @RequestMapping(
      value = "/Smart_rm/login",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> login(@RequestBody SmartRiLoginBodyRequestDto bodyRequest);

  @RequestMapping(value = "/Smart_rm/userDetail/{username}", method = RequestMethod.GET)
  public ResponseEntity<?> userDetail(
      @RequestHeader(name = "Authorization", required = true) String authorization,
      @PathVariable(name = "username", required = true) String username);
}
