package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMenor5OutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getSeriesMenor5Mapping",
    classes = {
      @ConstructorResult(
          targetClass = GetSeriesMenor5OutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class)
          })
    })
@Entity
public class GetSeriesMenor5DummyEntity {

  @Id private String dummyId;
}
