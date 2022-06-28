package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class AddValidNameRepository {

  private static final String SQL = "INSERT INTO validNames (name) VALUES (:name)";

  private final EntityManager entityManager;

  public AddValidNameRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(String name) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager.createNativeQuery(SQL).setParameter("name", name).executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
