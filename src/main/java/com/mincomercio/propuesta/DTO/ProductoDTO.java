package com.mincomercio.propuesta.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDTO {
    private int cantidad;
    private String nombre;
    private String origen;
    private String embarque;
    private double valorArancel;
    private double valorUnitario;
    private double valorTotal;
}
