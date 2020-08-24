package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.dominio.Categoria;
import com.mincomercio.propuesta.excepciones.CategoriaNoEncontradaExcepcion;
import com.mincomercio.propuesta.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCategoria {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    /**
     * Crea o modifica categorias
     * @param categoria
     * @return
     */
    public Categoria crearModificarCategoria(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    /**
     * Busca una categoria con determinado codigo
     * @param codigo
     * @return
     */
    public Categoria buscarCategoria(int codigo){
        return categoriaRepositorio
                .findById(codigo)
                .orElseThrow(() -> new CategoriaNoEncontradaExcepcion("Categoria no encontrada"));
    }

    /**
     * Obtiene una lista con todas las categorias
     * @return
     */
    public List<Categoria> obtenerCategorias() {
        return categoriaRepositorio.findAll();
    }
}
