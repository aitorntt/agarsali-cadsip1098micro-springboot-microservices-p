package com.dedalow.cad.micro.domain.internal;

import java.io.Serializable;
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
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Usuario implements Serializable {

  private static final long serialVersionUID = new Long(1L);

  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellidos")
  private String apellidos;

  @Column(name = "edad")
  private Integer edad;

  public Usuario(Long id) {
    this.id = id;
  }
}
