package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5Hasta18OutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getSeriesMenor5Hasta18Mapping",
    classes = {
      @ConstructorResult(
          targetClass = GetSeriesMenor5Hasta18OutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class)
          })
    })
@Entity
public class GetSeriesMenor5Hasta18DummyEntity {

  @Id private String dummyId;
}
