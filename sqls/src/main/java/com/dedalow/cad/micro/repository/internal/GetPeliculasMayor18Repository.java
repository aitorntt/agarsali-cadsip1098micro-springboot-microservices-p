package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMayor18OutOutputSQLResultDataDto;
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
public class GetPeliculasMayor18Repository {

  private static final String SQL =
      "SELECT titulo,valoracion, g.nombre as genero FROM Titulos t LEFT JOIN genero g ON g.id=t.generoId WHERE baby=0 AND medium=0 AND adult=1 AND pelicula=1 AND generoId=:generoId";

  private final EntityManager entityManager;

  public GetPeliculasMayor18Repository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<GetPeliculasMayor18OutOutputSQLResultDataDto> executeQuery(Long generoId) {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("generoId", generoId)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(GetPeliculasMayor18OutOutputSQLResultDataDto.class))
              .getResultList();

      return ((List<GetPeliculasMayor18OutOutputSQLResultDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<GetPeliculasMayor18OutOutputSQLResultDataDto>();
    }
  }
}
