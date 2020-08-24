package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.DTO.CrearProductoDTO;
import com.mincomercio.propuesta.DTO.ProductoDTO;
import com.mincomercio.propuesta.DTO.ProductoMapper;
import com.mincomercio.propuesta.dominio.Declaracion;
import com.mincomercio.propuesta.dominio.Producto;
import com.mincomercio.propuesta.excepciones.DeclaracionNoEncontradaExcepcion;
import com.mincomercio.propuesta.excepciones.ProductoNoValidoExcepcion;
import com.mincomercio.propuesta.repositorios.DeclaracionRepositorio;
import com.mincomercio.propuesta.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicioProducto {

    @Autowired
    private ProductoRepositorio repositorio;

    @Autowired
    private DeclaracionRepositorio declaracionRepositorio;

    @Autowired
    private ProductoMapper mapper;

    /**
     * Este metodo ayuda a configurar Productos
     * @param nuevoProducto
     * @return
     */
    public Producto crearModificarProducto(CrearProductoDTO nuevoProducto){
        Producto producto = mapper.mapToEntity(nuevoProducto);
        List<String> mensajesError = producto.esValido();
        if(mensajesError.size() == 0) {
            return repositorio.save(producto);
        } else {
            throw new ProductoNoValidoExcepcion(
                    mensajesError.stream()
                            .collect(Collectors.joining("/n")));
        }
    }

    /**
     * Obtiene la lista completa de Productos de determinada Declaracion
     * @return
     */
    public List<ProductoDTO> obtenerProductos(long id){
         Declaracion declaracion = declaracionRepositorio.findById(id)
                 .orElseThrow(() -> new DeclaracionNoEncontradaExcepcion("Declaracion no existe"));
         return declaracion.getProductos()
                 .stream()
                 .map(producto -> mapper.mapToDTO(producto))
                 .collect(Collectors.toList());
    }

    /**
     * Borra un Producto especifico dado un código de Producto
     * @param codigo
     * @return
     */

    public void borrarProducto(int codigo){
        repositorio.deleteById(codigo);
    }
}
