package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetTypesOutTypesDataDto;
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
public class GetTypesRepository {

  private static final String SQL = "SELECT id,name FROM typeProduct";

  private final EntityManager entityManager;

  public GetTypesRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<GetTypesOutTypesDataDto> executeQuery() {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .unwrap(NativeQuery.class)
              .setResultTransformer(Transformers.aliasToBean(GetTypesOutTypesDataDto.class))
              .getResultList();

      return ((List<GetTypesOutTypesDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<GetTypesOutTypesDataDto>();
    }
  }
}
