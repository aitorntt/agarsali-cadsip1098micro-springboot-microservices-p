package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class DeleteTypeRepository {

  private static final String SQL = "DELETE FROM typeProduct WHERE id=:id";

  private final EntityManager entityManager;

  public DeleteTypeRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(Long id) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager.createNativeQuery(SQL).setParameter("id", id).executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
