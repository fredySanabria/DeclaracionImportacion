package com.mincomercio.propuesta.DTO;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CrearProductoDTO {
    private long declaracion;
    private int cantidad;
    private String nombre;
    private int codigoCategoria;
    private int codigoPaisOrigen;
    private int codigoPaisEmbarque;
    private double valorUnitario;
}
