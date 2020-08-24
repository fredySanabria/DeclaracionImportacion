package com.mincomercio.propuesta.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
public class Producto {
    @Id
    @GeneratedValue
    @Column(name = "idProducto")
    private int id;
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaisOrigen", referencedColumnName = "idPais")
    private Pais origen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaisDestino", referencedColumnName = "idPais")
    private Pais embarque;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    private Categoria categoriaArancel;
    private int cantidad;
    private double valorDeclarado;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "FK_DECLARACION", nullable = false, updatable = false)
    protected Declaracion declaracion;
    /**
     * Calcular el arancel de un producto se considera
     * lógica de negocio solo del producto por eso se calcula en la entidad
     * @return valor arancel
     */
    public double calcularArancelProducto(){
        return getValorDeclarado() * (getCategoriaArancel().getArancel()/100D) * getCantidad();
    }

    /**
     * Verifica si el producto cumple las reglas de negocio
     * propias de la entidad de dominio
     * @return
     */
    public List<String> esValido() {
        List<String> mensajesError = new ArrayList<>();
        if(getEmbarque().isVetado()){
            mensajesError.add("Pais de embarque esta vetado para ingresar declaracion");
        }
        if(getOrigen().isVetado()){
            mensajesError.add("Pais de origen esta vetado para ingresar declaracion");
        }
        return mensajesError;
    }
}
