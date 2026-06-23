package com.votacion.ciudadano.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class CiudadanoRequest {

    @NotBlank
    private String dni;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @Email
    private String correo;

    private Boolean habilitado;
}