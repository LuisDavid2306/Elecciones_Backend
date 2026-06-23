package com.votacion.ciudadano.dto;

import lombok.Data;

@Data
public class CiudadanoResponse {

    private Long id;

    private String dni;

    private String nombres;

    private String apellidos;

    private String correo;

    private Boolean habilitado;
}