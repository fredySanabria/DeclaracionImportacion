package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.DTO.DeclaracionDTO;
import com.mincomercio.propuesta.DTO.DeclaracionMapper;
import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.excepciones.DeclaracionNoEncontradaExcepcion;
import com.mincomercio.propuesta.repositorios.DeclaracionRepositorio;
import com.mincomercio.propuesta.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeclaracion {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private DeclaracionRepositorio declaracionRepositorio;

    public DeclaracionDTO buscarDeclaracion(long codigo){
        Declaracion declaracion =  declaracionRepositorio
                .findById(codigo)
                .orElseThrow(() -> new DeclaracionNoEncontradaExcepcion("Declaracion no encontrada"));
        return DeclaracionMapper.mapToDTO(declaracion);
    }
}
