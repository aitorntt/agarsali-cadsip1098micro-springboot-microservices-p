package com.dedalow.cad.micro.commons.dto.request;

import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.AllExternalCodesEcJoinPeliculasInPeliculasDataDto;
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
public class AllExternalCodesEcJoinPeliculasBodyRequestDto implements Serializable {

  @JsonProperty("peliculas")
  @Singular("peliculas")
  @Lazy
  private List<AllExternalCodesEcJoinPeliculasInPeliculasDataDto> peliculas;

  @JsonProperty("peliculasAll")
  @Singular("peliculasAll")
  @Lazy
  private List<AllExternalCodesEcJoinPeliculasInPeliculasAllDataDto> peliculasAll;
}
