package com.dedalow.cad.micro.services.impl;


import com.dedalow.cad.micro.commons.dto.response.BackendResponse;
import com.dedalow.cad.micro.commons.dto.response.SaveProductCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.commons.services.EncodeService;
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

  @Autowired EncodeService encodeService;

  @Override
  @Transactional("internalTransactionManager")
  public BackendResponse<?> executeSaveProduct(Product inputDomain) {
    com.dedalow.cad.micro.domain.internal.Product inputDomainEntity =
        ProductEntityConverter.convertToEntityWithRelations(inputDomain);
    inputDomainEntity = productCRUDRepository.save(inputDomainEntity);
    return BackendResponse.builder()
        .body(
            SaveProductCRUDOkResponseResponseDto.builder()
                .outputDomainEntity(
                    ProductEntityConverter.convertToModelWithRelations(inputDomainEntity))
                .build())
        .isOk(true)
        .statusCode(200)
        .build();
  }

  @Override
  @Transactional("internalTransactionManager")
  public long countAll() {
    long queryTotal = productCRUDRepository.count();

    return queryTotal;
  }
}
