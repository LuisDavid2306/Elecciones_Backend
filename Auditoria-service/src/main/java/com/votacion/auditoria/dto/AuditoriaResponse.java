package com.votacion.auditoria.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AuditoriaResponse {
    private Long id;
    private String dni;
    private Long eleccionId;
    private Long candidatoId;
    private LocalDateTime fechaRegistro;
}