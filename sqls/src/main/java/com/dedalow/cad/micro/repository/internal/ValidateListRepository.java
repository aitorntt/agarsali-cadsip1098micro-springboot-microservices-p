package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class ValidateListRepository {

  private static final String SQL = "INSERT INTO validateList (price) VALUES (:price)";

  private final EntityManager entityManager;

  public ValidateListRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(Integer price) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager.createNativeQuery(SQL).setParameter("price", price).executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
