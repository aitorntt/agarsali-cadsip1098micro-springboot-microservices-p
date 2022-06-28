package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getPeliculasMenor5Hasta18Mapping",
    classes = {
      @ConstructorResult(
          targetClass = GetPeliculasMenor5Hasta18OutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class),
            @ColumnResult(name = "genero", type = String.class)
          })
    })
@Entity
public class GetPeliculasMenor5Hasta18DummyEntity {

  @Id private String dummyId;
}
