package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class DeleteUsuarioTransByNameRepository {

  private static final String SQL = "DELETE FROM UsuarioTrans WHERE username=:username";

  private final EntityManager entityManager;

  public DeleteUsuarioTransByNameRepository(
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
