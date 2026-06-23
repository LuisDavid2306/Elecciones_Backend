package com.votacion.candidatos.dto;

import lombok.Data;

@Data
public class CandidatoRequest {
	private String nombres;
    private String partido;
    private Long eleccionId;
}
