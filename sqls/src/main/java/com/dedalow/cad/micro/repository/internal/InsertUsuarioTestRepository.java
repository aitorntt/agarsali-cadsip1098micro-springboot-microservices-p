package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertUsuarioTestRepository {

  private static final String SQL =
      "INSERT INTO `Usuario` (`id`, `username`, `nombre`, `apellidos`, `edad`) VALUES (1, 'mdemarco', 'Maria', 'de Marco Arquez', 1),(2, 'idemarco', 'Ignacio', 'de Marco', 37),(7, 'marqued', 'Marta', 'Arqued Navaz', 34),(8, 'asainz', 'Sergio', 'Sanz', 17),(9, 'plaboreo', 'Pilar', 'Laboreo', 63)";

  private final EntityManager entityManager;

  public InsertUsuarioTestRepository(
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
