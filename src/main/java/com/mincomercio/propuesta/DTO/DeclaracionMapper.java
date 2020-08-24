package com.mincomercio.propuesta.DTO;

import com.mincomercio.propuesta.dominio.Declaracion;

public final class DeclaracionMapper {

    public static DeclaracionDTO mapToDTO(Declaracion declaracion){
        double totalArancel = Declaracion.obtenerTotalArancel(declaracion.getProductos());
        return DeclaracionDTO.builder()
                .productos(declaracion.getProductos())
                .totalArancel(totalArancel)
                .totalDeclaracion(Declaracion.obtenerTotalDeclaracion(declaracion.getProductos()) + totalArancel)
                .NIT(declaracion.getEmpresa().getNIT())
                .nombreEmpresa(declaracion.getEmpresa().getNombre())
                .build();
    }
}
