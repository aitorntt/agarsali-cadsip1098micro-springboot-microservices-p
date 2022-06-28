package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetUsuarioRepository {

  private static final String SQL =
      "SELECT nombre,apellidos,edad FROM Usuario WHERE username=:username";

  private final EntityManager entityManager;

  public GetUsuarioRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public GetUsuarioOutOutputSQLResultDto executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      Object ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("username", username)
              .unwrap(NativeQuery.class)
              .setResultTransformer(Transformers.aliasToBean(GetUsuarioOutOutputSQLResultDto.class))
              .getSingleResult();

      return ((GetUsuarioOutOutputSQLResultDto) ret);
    } catch (NoResultException ignore) {
      return null;
    }
  }
}
