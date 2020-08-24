package com.mincomercio.propuesta.interfaz_rest;

import com.mincomercio.propuesta.dominio.Categoria;
import com.mincomercio.propuesta.servicios.ServicioCategoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    ServicioCategoria servicio;

    @GetMapping(path = "/{id}")
    public Categoria getCategoria(@PathVariable Integer id) {
        return servicio.buscarCategoria(id);
    }

    @GetMapping(path = "/")
    public List<Categoria> getCategorias() {
        return servicio.obtenerCategorias();
    }

    @PostMapping(path = "/")
    public Categoria crearModificarCategoria(@Valid @RequestBody Categoria nuevoCategoria) {
        return servicio.crearModificarCategoria(nuevoCategoria);
    }
}
