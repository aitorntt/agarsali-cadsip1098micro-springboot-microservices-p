package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.domain.internal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCRUDRepository extends JpaRepository<Product, Long> {}
