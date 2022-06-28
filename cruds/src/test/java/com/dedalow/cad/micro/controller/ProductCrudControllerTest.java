package com.dedalow.cad.micro.controller;

import com.dedalow.cad.micro.commons.dto.request.SaveProductCRUDBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.response.SaveProductCRUDOkResponseResponseDto;
import com.dedalow.cad.micro.commons.model.Product;
import com.dedalow.cad.micro.repository.internal.ProductCRUDRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductCrudControllerTest {

  @LocalServerPort private int localPort;

  @Autowired ProductTestConnection connect;
  @Autowired ProductCRUDController productCRUDController;

  public static final String URI = "/productCRUD";

  @Test
  void createEntitySaveProduct() {
    String name = "name";
    String description = "description";
    Integer stock = 1;
    Long typeId = 1L;
    SaveProductCRUDBodyRequestDto bodyRequestDto =
        SaveProductCRUDBodyRequestDto.builder()
            .inputDomain(
                Product.builder()
                    .name(name)
                    .description(description)
                    .stock(stock)
                    .typeId(typeId)
                    .build())
            .build();

    ResponseEntity<SaveProductCRUDOkResponseResponseDto> response =
        (ResponseEntity<SaveProductCRUDOkResponseResponseDto>)
            productCRUDController.saveProduct(bodyRequestDto);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}

@Service
@RequiredArgsConstructor
class ProductTestConnection {

  @Autowired ProductCRUDRepository productCRUDRepository;

  @Transactional("internalTransactionManager")
  public Long createEmptyEntity() {
    com.dedalow.cad.micro.domain.internal.Product entity =
        new com.dedalow.cad.micro.domain.internal.Product();
    String name = "name";
    entity.setName(name);
    String description = "description";
    entity.setDescription(description);
    Integer stock = 1;
    entity.setStock(stock);
    Long typeId = 1L;
    entity.setTypeId(typeId);
    entity = productCRUDRepository.save(entity);
    return entity.getId();
  }
}
