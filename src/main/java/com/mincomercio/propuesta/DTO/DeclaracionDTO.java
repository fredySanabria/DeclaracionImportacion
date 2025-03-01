package com.mincomercio.propuesta.DTO;

import com.mincomercio.propuesta.dominio.Producto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class DeclaracionDTO {
    private long id;
    private String NIT;
    private String nombreEmpresa;
    private LocalDateTime fechaDeclaracion;
    private List<Producto> productos;
    private double totalDeclaracion;
    private double totalArancel;
}
