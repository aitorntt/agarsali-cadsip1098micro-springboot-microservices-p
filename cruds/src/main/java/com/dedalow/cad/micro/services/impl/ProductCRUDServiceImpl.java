package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.domain.util.ProductEntityConverter;
import com.dedalow.cad.micro.repository.internal.ProductCRUDRepository;
import com.dedalow.cad.micro.services.ProductCRUDService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCRUDServiceImpl implements ProductCRUDService {

  static final Logger logger = Logger.getLogger(ProductCRUDServiceImpl.class);

  @Autowired private ProductCRUDRepository productCRUDRepository;

  @Override
  @Transactional("internalTransactionManager")
  public Product executeSaveProduct(Product inputDomain) {
    com.dedalow.cad.micro.domain.internal.Product inputDomainEntity =
        ProductEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = productCRUDRepository.save(inputDomainEntity);
    return ProductEntityConverter.convertToModelWithRelations(inputDomainEntity);
  }

  @Override
  @Transactional("internalTransactionManager")
  public long countAll() {
    long queryTotal = productCRUDRepository.count();

    return queryTotal;
  }
}
