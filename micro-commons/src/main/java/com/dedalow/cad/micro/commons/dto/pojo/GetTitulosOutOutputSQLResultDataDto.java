package com.dedalow.cad.micro.commons.dto.pojo;

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
public class GetTitulosOutOutputSQLResultDataDto implements Serializable {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("titulo")
  private String titulo;

  @JsonProperty("valoracion")
  private Integer valoracion;

  @JsonProperty("baby")
  private Integer baby;

  @JsonProperty("medium")
  private Integer medium;

  @JsonProperty("adult")
  private Integer adult;

  @JsonProperty("pelicula")
  private Integer pelicula;

  @JsonProperty("generoId")
  private Long generoId;

  public void setId(Number id) {
    this.id = Objects.nonNull(id) ? id.longValue() : null;
  }

  public void setGeneroId(Number generoId) {
    this.generoId = Objects.nonNull(generoId) ? generoId.longValue() : null;
  }
}
