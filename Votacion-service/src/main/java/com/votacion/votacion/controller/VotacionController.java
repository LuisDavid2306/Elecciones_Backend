package com.votacion.votacion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.votacion.dto.VotoRequest;
import com.votacion.votacion.dto.VotoResponse;
import com.votacion.votacion.service.IVotacionService;

@RestController
@RequestMapping("/api/votaciones")
public class VotacionController {
	private final IVotacionService service;

    public VotacionController(IVotacionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VotoResponse>votar(@RequestBody VotoRequest request) {
        return ResponseEntity.ok(service.votar(request));
    }

    @GetMapping
    public ResponseEntity<List<VotoResponse>>listar() {
        return ResponseEntity.ok(service.listar());
    }
}
