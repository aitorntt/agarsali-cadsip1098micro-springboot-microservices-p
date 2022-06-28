package com.dedalow.cad.micro.commons.dto.pojo;


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
public class ValidateTypesRestRiMicroRestOutDataDto implements Serializable {

  @JsonProperty("typeName")
  private String typeName;

  @JsonProperty("typeValue")
  private Integer typeValue;

  @JsonProperty("address")
  @Singular("address")
  @Lazy
  private List<ValidateTypesRestRiMicroRestOutDataAddressItemListDto> address;
}