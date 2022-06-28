package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.ValidateTypesRestRiMicroRestBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rest")
public interface ValidateTypesRestRiProxy {

  @RequestMapping(
      value = "/ValidateTypesRest_rm/microRest",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> microRest(
      @RequestBody ValidateTypesRestRiMicroRestBodyRequestDto bodyRequest);
}
