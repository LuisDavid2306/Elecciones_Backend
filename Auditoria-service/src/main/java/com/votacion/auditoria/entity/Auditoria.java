package com.votacion.auditoria.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "auditoria")
@Data
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private Long eleccionId;
    private Long candidatoId;
    private LocalDateTime fechaRegistro;
}