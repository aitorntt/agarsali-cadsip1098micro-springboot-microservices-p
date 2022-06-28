package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertProductTestRepository {

  private static final String SQL =
      "INSERT INTO `product` (`id`, `name`, `description`, `stock`, `typeId`) VALUES (13, 'Tornillo', 'Tornillos 10,2 x 20', 100, 1),(14, 'Tuercas', 'Tuercas para tornillo 20x10', 200, 1),(15, 'Arandelas', 'Arandelas 10x20', 500, 1),(4, 'Tacos', 'Tacos 20x10', 500, 1),(5, 'Brocas', 'Brocas 8\', 30, 1),(6, 'Balancin', 'Balancines techo false 20cm', 10, 2),(7, 'Maceta', 'Maceta 20x30', 200, 2),(8, 'Abono', 'Abono especial jardín', 30, 2),(9, 'Plato de maceta', 'Plato 20cm de diametro', 200, 2),(10, 'Rastrillo', 'Rastrillo de jarddín', 100, 2),(11, 'Pintura Blanca 5L', 'Pintura Blanca 5L', 50, 3),(12, 'Pintura azul 3L', 'Pintura de exteriores azul 3L', 30, 3)";

  private final EntityManager entityManager;

  public InsertProductTestRepository(
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
