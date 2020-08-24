package com.mincomercio.propuesta.excepciones;

public class ProductoNoValidoExcepcion extends RuntimeException {
    public ProductoNoValidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
