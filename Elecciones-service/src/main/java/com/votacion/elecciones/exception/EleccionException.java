package com.votacion.elecciones.exception;

public class EleccionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EleccionException(String message) {
        super(message);
    }
}