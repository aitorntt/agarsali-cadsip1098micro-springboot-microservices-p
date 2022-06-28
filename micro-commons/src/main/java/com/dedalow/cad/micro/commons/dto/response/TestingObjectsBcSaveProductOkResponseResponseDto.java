package com.dedalow.cad.micro.commons.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
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
public class TestingObjectsBcSaveProductOkResponseResponseDto implements Serializable {

  @JsonProperty("typeId")
  private Long typeId;

  public void setTypeId(Number typeId) {
    this.typeId = Objects.nonNull(typeId) ? typeId.longValue() : null;
  }
}
