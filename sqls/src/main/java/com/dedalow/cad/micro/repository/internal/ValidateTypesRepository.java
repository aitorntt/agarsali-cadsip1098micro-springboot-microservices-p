package com.dedalow.cad.micro.repository.internal;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class ValidateTypesRepository {

  private static final String SQL =
      "INSERT INTO validateTypes (typeBoolean, typeDecimal, typeInteger, typeLong, typeLongText, typePassword, typeString) VALUES (:typeBoolean, :typeDecimal, :typeInteger, :typeLong, :typeLongText, :typePassword, :typeString)";

  private final EntityManager entityManager;

  public ValidateTypesRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void executeQuery(
      Boolean typeBoolean,
      BigDecimal typeDecimal,
      Integer typeInteger,
      Long typeLong,
      String typeLongText,
      String typePassword,
      String typeString) {
    try {
      this.entityManager.joinTransaction();

      this.entityManager
          .createNativeQuery(SQL)
          .setParameter("typeBoolean", typeBoolean)
          .setParameter("typeDecimal", typeDecimal)
          .setParameter("typeInteger", typeInteger)
          .setParameter("typeLong", typeLong)
          .setParameter("typeLongText", typeLongText)
          .setParameter("typePassword", typePassword)
          .setParameter("typeString", typeString)
          .executeUpdate();

    } catch (NoResultException ignore) {
      return;
    }
  }
}
