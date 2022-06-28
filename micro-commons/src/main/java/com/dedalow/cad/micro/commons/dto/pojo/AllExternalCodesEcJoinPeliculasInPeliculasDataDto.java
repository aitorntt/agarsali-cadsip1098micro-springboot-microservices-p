package com.dedalow.cad.micro.commons.dto.pojo;

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
public class AllExternalCodesEcJoinPeliculasInPeliculasDataDto implements Serializable {

  @JsonProperty("titulo")
  private String titulo;

  @JsonProperty("valoracion")
  private Integer valoracion;
}
