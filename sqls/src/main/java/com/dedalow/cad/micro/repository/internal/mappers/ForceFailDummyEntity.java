package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.ForceFailOutOutputSQLResultDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "forceFailMapping",
    classes = {
      @ConstructorResult(
          targetClass = ForceFailOutOutputSQLResultDataDto.class,
          columns = {@ColumnResult(name = "username", type = String.class)})
    })
@Entity
public class ForceFailDummyEntity {

  @Id private String dummyId;
}
