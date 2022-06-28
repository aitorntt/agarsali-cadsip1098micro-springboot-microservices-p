package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetTypeOutTypeDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getTypeMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetTypeOutTypeDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "name", type = String.class)
          })
    })
@Entity
public class GetTypeDummyEntity {

  @Id private String dummyId;
}
