package com.dedalow.cad.micro.commons.dto.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetTypesOutTypesDataDto implements Serializable {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  public void setId(Number id) {
    this.id = Objects.nonNull(id) ? id.longValue() : null;
  }
}
