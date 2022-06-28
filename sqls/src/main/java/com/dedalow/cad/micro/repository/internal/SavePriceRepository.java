package com.dedalow.cad.micro.repository.internal;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class SavePriceRepository {

  private static final String SQL =
      "INSERT INTO priceProduct (price,currency,productId) VALUES (:price,:currency,:productId)";

  private final EntityManager entityManager;

  public SavePriceRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(BigDecimal price, String currency, Long productId) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager
          .createNativeQuery(SQL)
          .setParameter("price", price)
          .setParameter("currency", currency)
          .setParameter("productId", productId)
          .executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
