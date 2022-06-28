package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioOutOutputSQLResultDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getUsuarioMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetUsuarioOutOutputSQLResultDto.class,
          columns = {
            @ColumnResult(name = "nombre", type = String.class),
            @ColumnResult(name = "apellidos", type = String.class),
            @ColumnResult(name = "edad", type = Integer.class)
          })
    })
@Entity
public class GetUsuarioDummyEntity {

  @Id private String dummyId;
}
