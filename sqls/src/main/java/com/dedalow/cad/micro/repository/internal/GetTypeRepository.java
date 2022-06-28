package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("internalTransactionManager")
public class GetTypeRepository {

  private static final String SQL = "SELECT id,name FROM typeProduct WHERE id=:typeId";

  private final EntityManager entityManager;

  public GetTypeRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public GetTypeOutTypeDto executeQuery(Long typeId) {
    try {
      this.entityManager.joinTransaction();

      Object ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("typeId", typeId)
              .unwrap(NativeQuery.class)
              .setResultTransformer(Transformers.aliasToBean(GetTypeOutTypeDto.class))
              .getSingleResult();

      return ((GetTypeOutTypeDto) ret);
    } catch (NoResultException ignore) {
      return null;
    }
  }
}
