package com.dedalow.cad.micro.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class ValidateList {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("price")
  private Integer price;

  public ValidateList(Long id) {
    this.id = id;
  }
}
