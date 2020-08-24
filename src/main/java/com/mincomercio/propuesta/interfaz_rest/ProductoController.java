package com.mincomercio.propuesta.interfaz_rest;

import com.mincomercio.propuesta.DTO.CrearProductoDTO;
import com.mincomercio.propuesta.DTO.ProductoDTO;
import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.dominio.Producto;
import com.mincomercio.propuesta.excepciones.ProductoNoValidoExcepcion;
import com.mincomercio.propuesta.repositorios.DeclaracionRepositorio;
import com.mincomercio.propuesta.repositorios.ProductoRepositorio;
import com.mincomercio.propuesta.servicios.ServicioProducto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    ServicioProducto servicioProducto;

    /**
     * Crea un nuevo producto si es valido
     * @param nuevoProducto
     * @return
     */
    @PostMapping(path = "/")
    public Producto crearProducto(@Valid @RequestBody CrearProductoDTO nuevoProducto){
        return servicioProducto.crearModificarProducto(nuevoProducto);
    }

    /**
     * Borra determinado producto
     * @param idProducto
     */
    @DeleteMapping(path = "/{id}")
    public void borrarProducto(@RequestBody int idProducto){
        servicioProducto.borrarProducto(idProducto);
    }

    /**
     * Obtiene una lista de productos de una declaracion
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public List<ProductoDTO> obtenerProductosPorDeclaracion(Long id){
        return servicioProducto.obtenerProductos(id);
    }

}
