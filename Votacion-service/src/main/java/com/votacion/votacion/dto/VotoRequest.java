package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class VotoRequest {
	private String dni;
    private Long eleccionId;
    private Long candidatoId;
}
