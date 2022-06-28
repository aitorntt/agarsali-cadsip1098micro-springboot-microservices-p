package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuariosTransOutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getUsuariosTransMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetUsuariosTransOutOutputSQLResultDataDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "username", type = String.class)
          })
    })
@Entity
public class GetUsuariosTransDummyEntity {

  @Id private String dummyId;
}
