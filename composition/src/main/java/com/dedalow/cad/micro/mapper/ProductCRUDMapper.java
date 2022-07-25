package com.dedalow.cad.micro.mapper;


import com.dedalow.cad.micro.commons.dto.request.SaveProductCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.proxy.ProductCRUDProxy;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductCRUDMapper {

  @Autowired ProductCRUDProxy productCRUDProxy;

  public BackendResponse<?> executeSaveProduct(Product inputDomain) throws CadException {

    SaveProductCRUDBodyRequestDto bodyInput =
        SaveProductCRUDBodyRequestDto.builder().inputDomain(inputDomain).build();

    BackendResponse.BackendResponseBuilder<Object> backendResponseBuilder =
        BackendResponse.builder();

    try {

      ResponseEntity<?> response = productCRUDProxy.saveProduct(bodyInput);

      backendResponseBuilder.statusCode(response.getStatusCode().value());
      backendResponseBuilder.isOk(true);
      backendResponseBuilder.body(response.getBody());

      return backendResponseBuilder.build();

    } catch (FeignException e) {
      throw e;
    }
  }
}
