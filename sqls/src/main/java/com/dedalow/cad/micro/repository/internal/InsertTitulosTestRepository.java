package com.dedalow.cad.micro.repository.internal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class InsertTitulosTestRepository {

  private static final String SQL =
      "INSERT INTO `Titulos` (`id`, `valoracion`, `titulo`, `baby`, `medium`, `adult`, `pelicula`, `generoId`) VALUES	(1, 4, 'El rey leon', 1, 1, 1, 1, 6),	(2, 5, 'Aladdin', 1, 1, 1, 1, 6),	(3, 4, 'Fantasia', 1, 0, 0, 1, 6),	(4, 4, 'Mulan', 1, 0, 0, 1, 6),	(5, 5, 'Origen', 0, 1, 0, 1, 5),	(6, 5, 'Braveheart', 0, 1, 0, 1, 7),	(7, 2, 'Saw', 0, 0, 1, 1, 2),	(8, 4, 'Un ciudadano ejemplar', 0, 0, 1, 1, 1),	(9, 5, 'Friends', 1, 1, 1, 0, 8),	(10, 4, 'Como conocí a vuestra madre', 1, 1, 1, 0, 8),	(11, 2, 'Pepa Pig', 1, 0, 0, 0, 6),	(12, 4, 'La patrulla canina', 1, 0, 0, 0, 6),	(13, 2, 'The sniffer', 0, 1, 0, 0, 8),	(14, 4, 'House', 0, 1, 0, 0, 8),	(15, 4, 'The walking dead', 0, 0, 1, 0, 2),	(16, 4, 'Black Mirror', 0, 0, 1, 0, 2),	(17, 4, 'Blancanieves', 1, 0, 0, 1, 6),	(18, 3, 'It', 0, 0, 1, 1, 2),	(19, 5, 'Interestelar', 1, 1, 1, 1, 5),	(20, 5, 'Fringe', 0, 0, 1, 0, 5),	(21, 5, 'El indomable Will Hunting', 1, 1, 1, 1, 4),	(22, 3, 'The Big Bang Theory', 1, 1, 1, 0, 0)";

  private final EntityManager entityManager;

  public InsertTitulosTestRepository(
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
