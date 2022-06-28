package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "showProductsMapping",
    classes = {
      @ConstructorResult(
          targetClass = ShowProductsOutProductsDataDto.class,
          columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "name", type = String.class),
            @ColumnResult(name = "description", type = String.class),
            @ColumnResult(name = "stock", type = Integer.class)
          })
    })
@Entity
public class ShowProductsDummyEntity {

  @Id private String dummyId;
}
