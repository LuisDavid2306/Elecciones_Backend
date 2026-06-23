package com.votacion.votacion.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VotoResponse {
	private Long id;
    private String dni;
    private Long eleccionId;
    private Long candidatoId;
    private LocalDateTime fechaVoto;
}
