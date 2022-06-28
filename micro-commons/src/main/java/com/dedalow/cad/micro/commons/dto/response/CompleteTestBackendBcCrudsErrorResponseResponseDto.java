package com.dedalow.cad.micro.commons.dto.response;

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
public class CompleteTestBackendBcCrudsErrorResponseResponseDto implements Serializable {

  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("errorCode")
  private Integer errorCode;
}
