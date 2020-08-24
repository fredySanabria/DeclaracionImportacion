package com.mincomercio.propuesta.excepciones;

public class ImportadorNoEncontradoExcepcion extends RuntimeException {
    public ImportadorNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
