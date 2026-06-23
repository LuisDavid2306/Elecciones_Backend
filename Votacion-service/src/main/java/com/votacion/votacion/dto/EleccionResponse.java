package com.votacion.votacion.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EleccionResponse {
	private Long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
}
