package com.mincomercio.propuesta.interfaz_rest;

import com.mincomercio.propuesta.DTO.DeclaracionDTO;
import com.mincomercio.propuesta.dominio.Pais;
import com.mincomercio.propuesta.servicios.ServicioDeclaracion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("declaraciones")
public class DeclaracionController {

    @Autowired
    ServicioDeclaracion servicio;

    @GetMapping(path = "/{id}")
    public DeclaracionDTO getDeclaracion(@PathVariable Integer id) {
        return servicio.buscarDeclaracion(id);
    }
    @PostMapping(path = "/")
    public DeclaracionDTO crearDeclaracion(@Valid @RequestBody DeclaracionDTO declaracion) {
        return servicio.crearDeclaracion(declaracion);
    }
}
