package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetUserByUsernameOutOutputSQLResultDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getUserByUsernameMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetUserByUsernameOutOutputSQLResultDto.class,
          columns = {
            @ColumnResult(name = "username", type = String.class),
            @ColumnResult(name = "password", type = String.class)
          })
    })
@Entity
public class GetUserByUsernameDummyEntity {

  @Id private String dummyId;
}
