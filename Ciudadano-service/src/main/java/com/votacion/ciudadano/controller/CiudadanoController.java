package com.votacion.ciudadano.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.ciudadano.dto.CiudadanoRequest;
import com.votacion.ciudadano.dto.CiudadanoResponse;
import com.votacion.ciudadano.service.ICiudadanoService;

@RestController
@RequestMapping("/api/ciudadanos")
public class CiudadanoController {
	
	private final ICiudadanoService service;

    public CiudadanoController(ICiudadanoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CiudadanoResponse> crear( @Validated @RequestBody CiudadanoRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<CiudadanoResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<CiudadanoResponse> obtenerPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(service.obtenerPorDni(dni));
    }
}
