package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5OutOutputSQLResultDataDto;
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
public class GetSeriesMenor5Repository {

  private static final String SQL =
      "SELECT titulo,valoracion FROM Titulos WHERE baby=1 AND medium=0 AND adult=0 AND pelicula=0";

  private final EntityManager entityManager;

  public GetSeriesMenor5Repository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<GetSeriesMenor5OutOutputSQLResultDataDto> executeQuery() {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(GetSeriesMenor5OutOutputSQLResultDataDto.class))
              .getResultList();

      return ((List<GetSeriesMenor5OutOutputSQLResultDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<GetSeriesMenor5OutOutputSQLResultDataDto>();
    }
  }
}
