package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertUserRepository {

  private static final String SQL =
      "INSERT INTO User (username, password, edad) VALUES (:username,:username, 18)";

  private final EntityManager entityManager;

  public InsertUserRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager.createNativeQuery(SQL).setParameter("username", username).executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
