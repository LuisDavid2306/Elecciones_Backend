package com.votacion.elecciones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.elecciones.dto.EleccionRequest;
import com.votacion.elecciones.dto.EleccionResponse;
import com.votacion.elecciones.service.IEleccionService;

@RestController
@RequestMapping("/api/elecciones")
public class EleccionController {
	
	private final IEleccionService service;

    public EleccionController(IEleccionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EleccionResponse> crear(@RequestBody EleccionRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<EleccionResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EleccionResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }
}
