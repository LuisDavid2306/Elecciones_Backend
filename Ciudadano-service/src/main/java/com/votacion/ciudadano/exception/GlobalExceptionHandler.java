package com.votacion.ciudadano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CiudadanoException.class)
    public ResponseEntity<ApiError> handleCiudadanoException(
            CiudadanoException ex) {

        HttpStatus status =
                ex.getMessage().contains("no encontrado")
                        ? HttpStatus.NOT_FOUND
                        : HttpStatus.CONFLICT;

        return ResponseEntity
                .status(status)
                .body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(
            Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(ex.getMessage()));
    }
}