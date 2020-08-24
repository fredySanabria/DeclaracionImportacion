package com.mincomercio.propuesta.repositorios;

import com.mincomercio.propuesta.dominio.Declaracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclaracionRepositorio extends JpaRepository<Declaracion, Long> {
}
