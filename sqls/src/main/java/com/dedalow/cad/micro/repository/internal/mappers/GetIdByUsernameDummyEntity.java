package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetIdByUsernameOutOutputSQLResultDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getIdByUsernameMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetIdByUsernameOutOutputSQLResultDto.class,
          columns = {@ColumnResult(name = "id", type = Long.class)})
    })
@Entity
public class GetIdByUsernameDummyEntity {

  @Id private String dummyId;
}
