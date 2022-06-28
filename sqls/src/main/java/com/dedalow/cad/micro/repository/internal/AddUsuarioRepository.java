package com.dedalow.cad.micro.repository.internal;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class AddUsuarioRepository {

  private static final String SQL =
      "INSERT INTO Usuario (username,nombre,apellidos,edad) VALUES (:username,:nombre,:apellidos,:edad)";

  private final EntityManager entityManager;

  public AddUsuarioRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(String nombre, String apellidos, Integer edad, String username) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager
          .createNativeQuery(SQL)
          .setParameter("nombre", nombre)
          .setParameter("apellidos", apellidos)
          .setParameter("edad", edad)
          .setParameter("username", username)
          .executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
