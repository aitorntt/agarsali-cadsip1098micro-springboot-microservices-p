package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetIdByUsernameOutOutputSQLResultDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetIdByUsernameRepository {

  private static final String SQL = "SELECT id FROM User WHERE username=:username";

  private final EntityManager entityManager;

  public GetIdByUsernameRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public GetIdByUsernameOutOutputSQLResultDto executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      Object ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("username", username)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(GetIdByUsernameOutOutputSQLResultDto.class))
              .getSingleResult();

      return ((GetIdByUsernameOutOutputSQLResultDto) ret);
    } catch (NoResultException ignore) {
      return null;
    }
  }
}
