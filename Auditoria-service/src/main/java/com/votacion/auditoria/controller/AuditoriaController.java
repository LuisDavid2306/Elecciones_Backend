package com.votacion.auditoria.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.votacion.auditoria.dto.AuditoriaResponse;
import com.votacion.auditoria.service.IAuditoriaService;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    private final IAuditoriaService service;

    public AuditoriaController(IAuditoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AuditoriaResponse>>listar() {
        return ResponseEntity.ok(service.listar());
    }
}