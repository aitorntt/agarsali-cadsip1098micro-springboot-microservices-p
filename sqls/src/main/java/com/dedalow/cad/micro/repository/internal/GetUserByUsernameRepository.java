package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetUserByUsernameOutOutputSQLResultDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetUserByUsernameRepository {

  private static final String SQL = "SELECT username,password FROM User WHERE username=:username";

  private final EntityManager entityManager;

  public GetUserByUsernameRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public GetUserByUsernameOutOutputSQLResultDto executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      Object ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("username", username)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(GetUserByUsernameOutOutputSQLResultDto.class))
              .getSingleResult();

      return ((GetUserByUsernameOutOutputSQLResultDto) ret);
    } catch (NoResultException ignore) {
      return null;
    }
  }
}
