package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class ForceFailRepository {

  private static final String SQL =
      "SELECT username FROM UsuarioTrans WHERE usernameFails=:username";

  private final EntityManager entityManager;

  public ForceFailRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<ForceFailOutOutputSQLResultDataDto> executeQuery(String username) {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("username", username)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(ForceFailOutOutputSQLResultDataDto.class))
              .getResultList();

      return ((List<ForceFailOutOutputSQLResultDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<ForceFailOutOutputSQLResultDataDto>();
    }
  }
}
