package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto;
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
public class GetPeliculasMenor5Hasta18Repository {

  private static final String SQL =
      "SELECT titulo,valoracion, g.nombre as genero FROM Titulos t LEFT JOIN genero g ON g.id=t.generoId WHERE  baby=0 AND medium=1 AND adult=0 AND pelicula=1 AND generoId=:generoId";

  private final EntityManager entityManager;

  public GetPeliculasMenor5Hasta18Repository(
      @Qualifier("internalEntityManagerFactory") final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto> executeQuery(Long generoId) {
    try {
      this.entityManager.joinTransaction();

      List ret =
          this.entityManager
              .createNativeQuery(SQL)
              .setParameter("generoId", generoId)
              .unwrap(NativeQuery.class)
              .setResultTransformer(
                  Transformers.aliasToBean(
                      GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto.class))
              .getResultList();

      return ((List<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto>) ret);
    } catch (NoResultException ignore) {
      return new ArrayList<GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto>();
    }
  }
}
