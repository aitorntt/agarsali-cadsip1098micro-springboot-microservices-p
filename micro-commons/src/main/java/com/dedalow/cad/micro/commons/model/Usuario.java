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
public class Usuario {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellidos")
  private String apellidos;

  @JsonProperty("edad")
  private Integer edad;

  public Usuario(Long id) {
    this.id = id;
  }
}
