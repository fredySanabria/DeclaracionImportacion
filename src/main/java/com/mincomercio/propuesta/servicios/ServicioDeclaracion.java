package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.DTO.DeclaracionDTO;
import com.mincomercio.propuesta.DTO.DeclaracionMapper;
import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.excepciones.DeclaracionNoEncontradaExcepcion;
import com.mincomercio.propuesta.repositorios.DeclaracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeclaracion {

    @Autowired
    private DeclaracionRepositorio declaracionRepositorio;

    @Autowired
    private DeclaracionMapper mapper;

    public DeclaracionDTO buscarDeclaracion(long codigo){
        Declaracion declaracion =  declaracionRepositorio
                .findById(codigo)
                .orElseThrow(() -> new DeclaracionNoEncontradaExcepcion("Declaracion no encontrada"));
        return mapper.mapToDTO(declaracion);
    }

    public DeclaracionDTO crearDeclaracion(DeclaracionDTO dto) {
        Declaracion declaracionNueva = declaracionRepositorio.save(mapper.mapToEntity(dto));
        return mapper.mapToDTO(declaracionNueva);
    }
}
