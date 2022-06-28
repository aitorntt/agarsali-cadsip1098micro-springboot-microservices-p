package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetSeriesMayor18OutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getSeriesMayor18Mapping",
    classes = {
      @ConstructorResult(
          targetClass = GetSeriesMayor18OutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class)
          })
    })
@Entity
public class GetSeriesMayor18DummyEntity {

  @Id private String dummyId;
}
