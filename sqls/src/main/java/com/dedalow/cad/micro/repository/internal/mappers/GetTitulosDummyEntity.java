package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetTitulosOutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getTitulosMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetTitulosOutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class),
            @ColumnResult(name = "baby", type = Integer.class),
            @ColumnResult(name = "medium", type = Integer.class),
            @ColumnResult(name = "adult", type = Integer.class),
            @ColumnResult(name = "pelicula", type = Integer.class),
            @ColumnResult(name = "generoId", type = Long.class)
          })
    })
@Entity
public class GetTitulosDummyEntity {

  @Id private String dummyId;
}
