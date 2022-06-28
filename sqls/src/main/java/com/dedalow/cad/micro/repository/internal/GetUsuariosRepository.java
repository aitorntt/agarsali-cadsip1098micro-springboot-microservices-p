package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuariosOutUsuariosDataDto;
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
public class GetUsuariosRepository {

  private static final String SQL = "SELECT id,username,nombre,apellidos,edad FROM Usuario";

  private final EntityManager entityManager;

  public GetUsuariosRepository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<GetUsuariosOutUsuariosDataDto> executeQuery() {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .unwrap(NativeQuery.class)
              .setResultTransformer(Transformers.aliasToBean(GetUsuariosOutUsuariosDataDto.class))
              .getResultList();

      return ((List<GetUsuariosOutUsuariosDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<GetUsuariosOutUsuariosDataDto>();
    }
  }
}
