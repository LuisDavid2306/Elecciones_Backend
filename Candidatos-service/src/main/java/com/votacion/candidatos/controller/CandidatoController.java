package com.votacion.candidatos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.candidatos.dto.CandidatoRequest;
import com.votacion.candidatos.dto.CandidatoResponse;
import com.votacion.candidatos.service.ICandidatoService;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {
	
	private final ICandidatoService service;

    public CandidatoController(ICandidatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CandidatoResponse> crear( @RequestBody CandidatoRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<CandidatoResponse>>listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/eleccion/{id}")
    public ResponseEntity<List<CandidatoResponse>> listarPorEleccion(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorEleccion(id));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoResponse>obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }
}
