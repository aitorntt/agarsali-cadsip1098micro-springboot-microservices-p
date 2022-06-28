package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetGenerosOutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getGenerosMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetGenerosOutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "nombre", type = String.class)
          })
    })
@Entity
public class GetGenerosDummyEntity {

  @Id private String dummyId;
}
