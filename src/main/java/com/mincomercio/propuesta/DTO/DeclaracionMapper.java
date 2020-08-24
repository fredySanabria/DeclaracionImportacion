package com.mincomercio.propuesta.DTO;

import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.dominio.Importador;
import com.mincomercio.propuesta.excepciones.ImportadorNoEncontradoExcepcion;
import com.mincomercio.propuesta.repositorios.ImportadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class DeclaracionMapper {

    @Autowired
    private ImportadorRepositorio importadorRepositorio;

    public DeclaracionDTO mapToDTO(Declaracion declaracion){
        double totalArancel = Declaracion.obtenerTotalArancel(declaracion.getProductos());
        return DeclaracionDTO.builder()
                .productos(declaracion.getProductos())
                .totalArancel(totalArancel)
                .totalDeclaracion(Declaracion.obtenerTotalDeclaracion(declaracion.getProductos()) + totalArancel)
                .NIT(declaracion.getEmpresa().getNIT())
                .nombreEmpresa(declaracion.getEmpresa().getNombre())
                .fechaDeclaracion(declaracion.getFechaDeclaracion())
                .build();
    }

    public Declaracion mapToEntity(DeclaracionDTO dto){
        Importador importador = importadorRepositorio
                .findById(dto.getNIT())
                .orElseThrow(() -> new ImportadorNoEncontradoExcepcion("Importador no existe"));
        return Declaracion.builder()
                .empresa(importador)
                .productos(new ArrayList<>())
                .fechaDeclaracion(LocalDateTime.now())
                .build();
    }
}
