package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateObjectsInUserDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class ValidateObjectsRepository {

  private static final String SQL = "INSERT INTO validateObjects (name, age) VALUES (:name,:age)";

  private final EntityManager entityManager;

  public ValidateObjectsRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(ValidateObjectsInUserDto user) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager
          .createNativeQuery(SQL)
          .setParameter("name", user.getName())
          .setParameter("age", user.getAge())
          .executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
