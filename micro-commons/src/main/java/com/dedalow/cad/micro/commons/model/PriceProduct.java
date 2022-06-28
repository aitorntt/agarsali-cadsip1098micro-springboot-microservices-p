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
public class PriceProduct {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("productId")
  private Long productId;

  public PriceProduct(Long id) {
    this.id = id;
  }
}
