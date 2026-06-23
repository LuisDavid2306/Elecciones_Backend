package com.votacion.elecciones.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EleccionRequest {
	
	private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
}
