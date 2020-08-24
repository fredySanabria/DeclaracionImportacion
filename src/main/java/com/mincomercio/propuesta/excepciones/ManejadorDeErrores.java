package com.mincomercio.propuesta.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ManejadorDeErrores extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> ManejadorExcepcionesGenerales(Exception exception, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(DeclaracionNoEncontradaExcepcion.class)
    public final ResponseEntity<Object> ManejadorDeclaracionNoEncontrada(DeclaracionNoEncontradaExcepcion exception, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaisNoEncontradoExcepcion.class)
    public final ResponseEntity<Object> ManejadorPaisNoEncontrado(PaisNoEncontradoExcepcion exception, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoriaNoEncontradaExcepcion.class)
    public final ResponseEntity<Object> ManejadorCategoriaNoEncontrada(CategoriaNoEncontradaExcepcion exception, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductoNoValidoExcepcion.class)
    public final ResponseEntity<Object> ManejadorProductoNoValido(ProductoNoValidoExcepcion exception, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        com.mincomercio.propuesta.excepciones.ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Fallo en Validacion", ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
