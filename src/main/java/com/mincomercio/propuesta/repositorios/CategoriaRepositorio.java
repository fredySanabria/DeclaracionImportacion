package com.mincomercio.propuesta.repositorios;

import com.mincomercio.propuesta.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
