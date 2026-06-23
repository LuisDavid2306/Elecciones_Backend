package com.votacion.resultados.dto;


import lombok.Data;

@Data
public class ResultadoResponse {

    private Long id;
    private Long eleccionId;
    private Long candidatoId;
    private Integer totalVotos;
}