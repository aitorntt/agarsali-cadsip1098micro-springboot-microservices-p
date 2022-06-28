package com.dedalow.cad.micro.commons.dto.request;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInGenerosDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcAddGenerosInPeliculasDataDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class AllExternalCodesEcAddGenerosBodyRequestDto implements Serializable {

  @JsonProperty("peliculas")
  @Singular("peliculas")
  @Lazy
  private List<AllExternalCodesEcAddGenerosInPeliculasDataDto> peliculas;

  @JsonProperty("valoracionMedia")
  private BigDecimal valoracionMedia;

  @JsonProperty("generos")
  @Singular("generos")
  @Lazy
  private List<AllExternalCodesEcAddGenerosInGenerosDataDto> generos;

  @JsonProperty("genero")
  private String genero;
}
