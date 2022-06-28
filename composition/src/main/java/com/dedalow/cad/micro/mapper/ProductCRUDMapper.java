package com.dedalow.cad.micro.mapper;


import com.dedalow.cad.micro.commons.dto.request.SaveProductCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.SaveProductCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.exception.CadException;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.commons.util.ObjectMapperUtil;
import com.dedalow.cad.micro.proxy.ProductCRUDProxy;
import com.fasterxml.jackson.core.type.TypeReference;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductCRUDMapper {

  @Autowired ProductCRUDProxy productCRUDProxy;

  public Product executeSaveProduct(Product inputDomain) throws CadException {

    SaveProductCRUDBodyRequestDto bodyInput =
        SaveProductCRUDBodyRequestDto.builder().inputDomain(inputDomain).build();

    try {
      ResponseEntity<?> response = productCRUDProxy.saveProduct(bodyInput);

      return ObjectMapperUtil.convertValue(
              response.getBody(), new TypeReference<SaveProductCRUDOkResponseResponseDto>() {})
          .getOutputDomainEntity();
    } catch (FeignException e) {
      throw e;
    }
  }
}
