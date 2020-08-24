package com.mincomercio.propuesta.dominio;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Pais {
    @Id
    @GeneratedValue
    @Column(name = "idPais")
    private int id;

    @NotNull(message = "Nombre es obligatorio")
    private String nombre;

    @NotNull(message = "configurar si es un pais Vetado")
    private boolean isVetado;

}
