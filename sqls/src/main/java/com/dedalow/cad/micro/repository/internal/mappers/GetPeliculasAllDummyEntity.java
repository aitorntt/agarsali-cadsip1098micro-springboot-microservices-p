package com.dedalow.cad.micro.repository.internal.mappers;

import com.dedalow.cad.micro.commons.dto.pojo.GetPeliculasAllOutPeliculasAllDataDto;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name = "getPeliculasAllMapping",
    classes = {
      @ConstructorResult(
          targetClass = GetPeliculasAllOutPeliculasAllDataDto.class,
          columns = {
            @ColumnResult(name = "titulo", type = String.class),
            @ColumnResult(name = "valoracion", type = Integer.class),
            @ColumnResult(name = "genero", type = String.class)
          })
    })
@Entity
public class GetPeliculasAllDummyEntity {

  @Id private String dummyId;
}
