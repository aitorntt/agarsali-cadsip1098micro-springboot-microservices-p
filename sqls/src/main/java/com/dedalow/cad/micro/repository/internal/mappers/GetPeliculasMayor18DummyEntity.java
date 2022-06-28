package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasMayor18OutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getPeliculasMayor18Mapping",
    classes = {
      @ConstructorResult(
          targetClass = GetPeliculasMayor18OutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class),
            @ColumnResult(name = "genero", type = String.class)
          })
    })
@Entity
public class GetPeliculasMayor18DummyEntity {

  @Id private String dummyId;
}
