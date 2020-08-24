package com.mincomercio.propuesta.interfaz_rest;

import com.mincomercio.propuesta.dominio.Pais;
import com.mincomercio.propuesta.servicios.ServicioPais;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("paises")
public class PaisController {

    @Autowired
    ServicioPais servicio;

    @GetMapping(path = "/{id}")
    public Pais getPais(@PathVariable Integer id) {
        return servicio.buscarPais(id);
    }

    @GetMapping(path = "/")
    public List<Pais> getPaises() {
        return servicio.obtenerPaises();
    }

    @PostMapping(path = "/")
    public Pais crearModificarPais(@Valid @RequestBody Pais nuevoPais) {
        return servicio.crearModificarPais(nuevoPais);
    }
}
