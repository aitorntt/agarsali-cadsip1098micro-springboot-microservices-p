package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertGeneroTestRepository {

  private static final String SQL =
      "INSERT INTO `genero` (`id`, `nombre`) VALUES	(1, 'Thriller'),	(2, 'Terror'),	(3, 'Drama'),	(4, 'Romántica'),	(5, 'Ciencia ficcion'),	(6, 'Dibujos'),	(7, 'Belica'),	(8, 'Comedia')";

  private final EntityManager entityManager;

  public InsertGeneroTestRepository(
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
