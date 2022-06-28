package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.SaveProductCRUDBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cruds")
public interface ProductCRUDProxy {

  @RequestMapping(
      value = "/productCRUD/saveProduct",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> saveProduct(@RequestBody SaveProductCRUDBodyRequestDto bodyRequest);
}
