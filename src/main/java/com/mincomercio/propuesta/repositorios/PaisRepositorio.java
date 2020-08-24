package com.mincomercio.propuesta.repositorios;

import com.mincomercio.propuesta.dominio.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais,Integer> {
}
