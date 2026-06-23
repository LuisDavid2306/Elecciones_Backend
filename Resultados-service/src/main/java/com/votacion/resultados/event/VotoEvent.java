package com.votacion.resultados.event;

import java.io.Serializable;
import lombok.Data;

@Data
public class VotoEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dni;
    private Long eleccionId;
    private Long candidatoId;
}