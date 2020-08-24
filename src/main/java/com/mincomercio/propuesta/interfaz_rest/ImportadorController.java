package com.mincomercio.propuesta.interfaz_rest;

import com.mincomercio.propuesta.dominio.Importador;
import com.mincomercio.propuesta.servicios.ServicioImportador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("Importadores")
public class ImportadorController {

    @Autowired
    ServicioImportador servicio;

    @GetMapping(path = "/{id}")
    public Importador buscarImportador(@PathVariable String nit) {
        return servicio.buscarImportador(nit);
    }

    @GetMapping(path = "/")
    public List<Importador> buscarImportadores() {
        return servicio.obtenerImportadores();
    }

    @PostMapping(path = "/")
    public Importador crearModificarImportador(@Valid @RequestBody Importador nuevoImportador) {
        return servicio.crearModificarImportador(nuevoImportador);
    }
}
