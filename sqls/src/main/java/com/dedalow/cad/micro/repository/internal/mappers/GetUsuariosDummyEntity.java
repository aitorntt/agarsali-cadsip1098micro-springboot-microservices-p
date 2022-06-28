package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuariosOutUsuariosDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getUsuariosMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetUsuariosOutUsuariosDataDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "username", type = String.class),
            @ColumnResult(name = "nombre", type = String.class),
            @ColumnResult(name = "apellidos", type = String.class),
            @ColumnResult(name = "edad", type = Integer.class)
          })
    })
@Entity
public class GetUsuariosDummyEntity {

  @Id private String dummyId;
}
