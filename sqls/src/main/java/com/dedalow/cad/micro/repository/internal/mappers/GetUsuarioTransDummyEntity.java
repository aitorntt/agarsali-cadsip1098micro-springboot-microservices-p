package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetUsuarioTransOutOutputSQLResultDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getUsuarioTransMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetUsuarioTransOutOutputSQLResultDto.class,
          columns = {@ColumnResult(name = "username", type = String.class)})
    })
@Entity
public class GetUsuarioTransDummyEntity {

  @Id private String dummyId;
}
