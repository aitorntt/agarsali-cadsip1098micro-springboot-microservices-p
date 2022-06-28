package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertTypeProductTestRepository {

  private static final String SQL =
      "INSERT INTO `typeProduct` (`id`, `name`) VALUES	(1, 'Ferretería'),	(2, 'Jardinería'),	(3, 'Pintura'),	(4, 'Albañilería')";

  private final EntityManager entityManager;

  public InsertTypeProductTestRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery() {
    try {
      this.entityManager.joinTransaction();

      this.entityManager.createNativeQuery(SQL).executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
