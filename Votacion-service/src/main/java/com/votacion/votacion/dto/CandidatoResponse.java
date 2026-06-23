package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class CandidatoResponse {
	private Long id;
    private String nombres;
    private String partido;
    private Long eleccionId;
}
