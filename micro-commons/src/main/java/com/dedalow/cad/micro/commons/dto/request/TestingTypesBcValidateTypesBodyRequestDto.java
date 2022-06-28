package com.dedalow.cad.micro.commons.dto.request;

import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeListDataDto;
import com.dedalow.cad.micro.commons.dto.pojo.TestingTypesBcValidateTypesInTypeObjectDto;
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
public class TestingTypesBcValidateTypesBodyRequestDto implements Serializable {

  @JsonProperty("typeBoolean")
  private Boolean typeBoolean;

  @JsonProperty("typeDecimal")
  private BigDecimal typeDecimal;

  @JsonProperty("typeInteger")
  private Integer typeInteger;

  @JsonProperty("typeList")
  @Singular("typeList")
  @Lazy
  private List<TestingTypesBcValidateTypesInTypeListDataDto> typeList;

  @JsonProperty("typeLong")
  private Long typeLong;

  @JsonProperty("typeLongText")
  private String typeLongText;

  @JsonProperty("typePassword")
  private String typePassword;

  @JsonProperty("typeString")
  private String typeString;

  @JsonProperty("typeObject")
  private TestingTypesBcValidateTypesInTypeObjectDto typeObject;
}
