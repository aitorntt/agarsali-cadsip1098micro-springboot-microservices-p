package com.dedalow.cad.micro.services;

import com.dedalow.cad.micro.commons.model.Product;

public interface ProductCRUDService {

  public Product executeSaveProduct(Product inputDomain);

  long countAll();
}
