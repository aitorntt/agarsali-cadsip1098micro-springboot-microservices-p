package com.dedalow.cad.micro.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
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
public class ValidateTypes {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("typeBoolean")
  private Boolean typeBoolean;

  @JsonProperty("typeDecimal")
  private BigDecimal typeDecimal;

  @JsonProperty("typeInteger")
  private Integer typeInteger;

  @JsonProperty("typeLong")
  private Long typeLong;

  @JsonProperty("typeLongText")
  private String typeLongText;

  @JsonProperty("typePassword")
  private String typePassword;

  @JsonProperty("typeString")
  private String typeString;

  public ValidateTypes(Long id) {
    this.id = id;
  }
}
