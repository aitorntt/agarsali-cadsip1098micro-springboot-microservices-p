package com.dedalow.cad.micro.commons.dto.request;

import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInPricesPriceDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcSaveProductInProductDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.springframework.context.annotation.Lazy;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestingObjectsBcSaveProductBodyRequestDto implements Serializable {

  @JsonProperty("product")
  private TestingObjectsBcSaveProductInProductDto product;

  @JsonProperty("prices")
  @Singular("prices")
  @Lazy
  private List<TestingObjectsBcSaveProductInPricesPriceDto> prices;
}
