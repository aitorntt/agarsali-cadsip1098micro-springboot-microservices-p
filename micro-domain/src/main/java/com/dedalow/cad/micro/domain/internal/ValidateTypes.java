package com.dedalow.cad.micro.domain.internal;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "validateTypes")
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class ValidateTypes implements Serializable {

  private static final long serialVersionUID = new Long(1L);

  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "typeBoolean")
  private Boolean typeBoolean;

  @Column(name = "typeDecimal")
  private BigDecimal typeDecimal;

  @Column(name = "typeInteger")
  private Integer typeInteger;

  @Column(name = "typeLong")
  private Long typeLong;

  @Column(name = "typeLongText")
  private String typeLongText;

  @Column(name = "typePassword")
  private String typePassword;

  @Column(name = "typeString")
  private String typeString;

  public ValidateTypes(Long id) {
    this.id = id;
  }
}
