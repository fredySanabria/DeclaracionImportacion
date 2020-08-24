package com.mincomercio.propuesta.dominio;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
public class Categoria {
    @Id
    @GeneratedValue
    @Column(name = "idCategoria")
    private int id;
    private String nombre;
    private int arancel;
}
