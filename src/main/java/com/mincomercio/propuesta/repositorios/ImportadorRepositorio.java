package com.mincomercio.propuesta.repositorios;

import com.mincomercio.propuesta.dominio.Importador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportadorRepositorio extends JpaRepository<Importador, String> {
}
