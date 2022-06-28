package com.dedalow.cad.micro.commons.dto.response;

import com.dedalow.cad.micro.commons.dto.pojo.ValidateTypesRestRiMicroRestAuxOutDataDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
public class ValidateTypesRestRiMicroRestAuxOkResponseDto implements Serializable {

  @JsonProperty("data")
  private ValidateTypesRestRiMicroRestAuxOutDataDto data;
}
