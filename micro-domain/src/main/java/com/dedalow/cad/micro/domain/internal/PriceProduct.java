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
@Table(name = "priceProduct")
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class PriceProduct implements Serializable {

  private static final long serialVersionUID = new Long(1L);

  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "currency")
  private String currency;

  @Column(name = "productId")
  private Long productId;

  public PriceProduct(Long id) {
    this.id = id;
  }
}
