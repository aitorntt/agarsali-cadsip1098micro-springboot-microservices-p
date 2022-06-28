package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
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
public class ShowProductsRepository {

  private static final String SQL =
      "SELECT id,name,description,stock FROM product WHERE typeId=:typeId";

  private final EntityManager entityManager;

  public ShowProductsRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<ShowProductsOutProductsDataDto> executeQuery(Long typeId) {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("typeId", typeId)
              .unwrap(NativeQuery.class)
              .setResultTransformer(Transformers.aliasToBean(ShowProductsOutProductsDataDto.class))
              .getResultList();

      return ((List<ShowProductsOutProductsDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<ShowProductsOutProductsDataDto>();
    }
  }
}
