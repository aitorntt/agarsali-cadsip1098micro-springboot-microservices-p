package com.dedalow.cad.micro.commons.dto.request;

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
public class AddTituloBodyRequestDto implements Serializable {

  @JsonProperty("adult")
  private Integer adult;

  @JsonProperty("valoracion")
  private Integer valoracion;

  @JsonProperty("baby")
  private Integer baby;

  @JsonProperty("pelicula")
  private Integer pelicula;

  @JsonProperty("medium")
  private Integer medium;

  @JsonProperty("titulo")
  private String titulo;

  @JsonProperty("generoId")
  private Long generoId;
}
