package com.dedalow.cad.micro.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Titulos {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("titulo")
  private String titulo;

  @JsonProperty("baby")
  private Integer baby;

  @JsonProperty("medium")
  private Integer medium;

  @JsonProperty("adult")
  private Integer adult;

  @JsonProperty("pelicula")
  private Integer pelicula;

  @JsonProperty("valoracion")
  private Integer valoracion;

  @JsonProperty("generoId")
  private Long generoId;

  public Titulos(Long id) {
    this.id = id;
  }
}
