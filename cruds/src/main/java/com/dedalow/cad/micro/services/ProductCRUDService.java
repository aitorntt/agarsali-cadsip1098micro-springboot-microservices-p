package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.model.Product;

public interface ProductCRUDService {

  public BackendResponse<?> executeSaveProduct(Product inputDomain);

  long countAll();
}
