package com.dedalow.cad.micro.repository.internal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetListUsuariosRepository {

  private static final String SQL = "SELECT nombre FROM Usuario";

  private final EntityManager entityManager;

  public GetListUsuariosRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<String> executeQuery() {
    try {
      this.entityManager.joinTransaction();

      List ret = this.entityManager.createNativeQuery(SQL).getResultList();

      return ((List<String>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<String>();
    }
  }
}
