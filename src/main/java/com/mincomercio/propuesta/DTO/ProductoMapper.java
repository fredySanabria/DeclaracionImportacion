package com.mincomercio.propuesta.DTO;

import com.mincomercio.propuesta.dominio.Categoria;
import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.dominio.Pais;
import com.mincomercio.propuesta.dominio.Producto;
import com.mincomercio.propuesta.excepciones.CategoriaNoEncontradaExcepcion;
import com.mincomercio.propuesta.excepciones.DeclaracionNoEncontradaExcepcion;
import com.mincomercio.propuesta.excepciones.PaisNoEncontradoExcepcion;
import com.mincomercio.propuesta.repositorios.CategoriaRepositorio;
import com.mincomercio.propuesta.repositorios.DeclaracionRepositorio;
import com.mincomercio.propuesta.repositorios.PaisRepositorio;
import com.mincomercio.propuesta.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoMapper {

    @Autowired
    private DeclaracionRepositorio declaracionRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private PaisRepositorio paisRepositorio;

    public ProductoDTO mapToDTO(Producto producto){
        double totalArancel = producto.calcularArancelProducto();
        return ProductoDTO.builder()
                .cantidad(producto.getCantidad())
                .nombre(producto.getNombre())
                .embarque(producto.getEmbarque().getNombre())
                .origen(producto.getOrigen().getNombre())
                .valorUnitario(producto.getValorDeclarado())
                .valorArancel(totalArancel)
                .valorTotal((producto.getValorDeclarado() * producto.getCantidad()) + totalArancel)
                .build();
    }
    public Producto mapToEntity(CrearProductoDTO nuevoProducto){
        Categoria categoria = categoriaRepositorio
                .findById(nuevoProducto.getCodigoCategoria())
                .orElseThrow(() -> new CategoriaNoEncontradaExcepcion("Categoria no encontrada"));
        Pais paisOrigen = paisRepositorio.findById(nuevoProducto.getCodigoPaisOrigen())
                .orElseThrow(() -> new PaisNoEncontradoExcepcion("Pais no encontrado"));
        Pais paisEmbarque = paisRepositorio.findById(nuevoProducto.getCodigoPaisEmbarque())
                .orElseThrow(() -> new PaisNoEncontradoExcepcion("Pais no encontrado"));
        Declaracion declaracion = declaracionRepositorio.findById(nuevoProducto.getDeclaracion())
                .orElseThrow(() -> new DeclaracionNoEncontradaExcepcion("Declaracion no existe"));
        return Producto.builder()
                .nombre(nuevoProducto.getNombre())
                .cantidad(nuevoProducto.getCantidad())
                .embarque(paisEmbarque)
                .origen(paisOrigen)
                .categoriaArancel(categoria)
                .declaracion(declaracion)
                .valorDeclarado(nuevoProducto.getValorUnitario())
                .build();
    }
}
