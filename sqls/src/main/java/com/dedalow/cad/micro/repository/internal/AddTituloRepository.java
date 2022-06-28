package com.dedalow.cad.micro.repository.internal;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class AddTituloRepository {

  private static final String SQL =
      "INSERT INTO Titulos (titulo,valoracion,baby,medium,adult,pelicula, generoId) VALUES (:titulo,:valoracion,:baby,:medium,:adult,:pelicula, :generoId)";

  private final EntityManager entityManager;

  public AddTituloRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(
      Integer adult,
      Integer valoracion,
      Integer baby,
      Integer pelicula,
      Integer medium,
      String titulo,
      Long generoId) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager
          .createNativeQuery(SQL)
          .setParameter("adult", adult)
          .setParameter("valoracion", valoracion)
          .setParameter("baby", baby)
          .setParameter("pelicula", pelicula)
          .setParameter("medium", medium)
          .setParameter("titulo", titulo)
          .setParameter("generoId", generoId)
          .executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
