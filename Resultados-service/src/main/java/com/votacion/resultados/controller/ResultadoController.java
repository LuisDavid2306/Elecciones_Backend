package com.votacion.resultados.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.votacion.resultados.dto.ResultadoResponse;
import com.votacion.resultados.service.IResultadoService;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    private final IResultadoService service;

    public ResultadoController(IResultadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResultadoResponse>>listar() {
        return ResponseEntity.ok(service.listar());
    }
}