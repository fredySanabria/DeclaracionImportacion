package com.mincomercio.propuesta.excepciones;

public class CategoriaNoEncontradaExcepcion extends RuntimeException {
    public CategoriaNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
