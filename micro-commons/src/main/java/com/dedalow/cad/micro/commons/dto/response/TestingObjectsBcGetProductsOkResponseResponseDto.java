package com.dedalow.cad.micro.commons.dto.response;

import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutProductsServerActionParameterResponseDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingObjectsBcGetProductsOutTypeDto;
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
public class TestingObjectsBcGetProductsOkResponseResponseDto implements Serializable {

  @JsonProperty("type")
  private TestingObjectsBcGetProductsOutTypeDto type;

  @JsonProperty("products")
  @Singular("products")
  @Lazy
  private List<TestingObjectsBcGetProductsOutProductsServerActionParameterResponseDto> products;
}
