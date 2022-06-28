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
public class SavePriceBodyRequestDto implements Serializable {

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("productId")
  private Long productId;
}
