package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetUsuarioTransRepository {

  private static final String SQL = "SELECT username FROM UsuarioTrans WHERE username=:username";

  private final EntityManager entityManager;

  public GetUsuarioTransRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public GetUsuarioTransOutOutputSQLResultDto executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      Object ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("username", username)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(GetUsuarioTransOutOutputSQLResultDto.class))
              .getSingleResult();

      return ((GetUsuarioTransOutOutputSQLResultDto) ret);
    } catch (NoResultException ignore) {
      return null;
    }
  }
}
