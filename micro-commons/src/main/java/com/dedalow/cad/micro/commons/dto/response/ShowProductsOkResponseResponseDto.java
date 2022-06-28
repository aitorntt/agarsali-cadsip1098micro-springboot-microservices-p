package com.dedalow.cad.micro.commons.dto.response;

import com.dedalow.cad.micro.commons.dto.pojo.ShowProductsOutProductsDataDto;
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
public class ShowProductsOkResponseResponseDto implements Serializable {

  @JsonProperty("products")
  @Singular("products")
  @Lazy
  private List<ShowProductsOutProductsDataDto> products;
}
