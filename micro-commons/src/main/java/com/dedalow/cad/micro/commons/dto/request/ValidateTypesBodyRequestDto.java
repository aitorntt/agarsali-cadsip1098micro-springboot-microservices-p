package com.dedalow.cad.micro.commons.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ValidateTypesBodyRequestDto implements Serializable {

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
}
