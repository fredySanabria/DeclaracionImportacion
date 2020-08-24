package com.mincomercio.propuesta.repositorios;

import com.mincomercio.propuesta.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

    List<Producto> findByDeclaracion(int idDeclaracion);
}
