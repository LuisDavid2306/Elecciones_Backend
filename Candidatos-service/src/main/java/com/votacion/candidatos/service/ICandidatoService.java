package com.votacion.candidatos.service;

import java.util.List;

import com.votacion.candidatos.dto.CandidatoRequest;
import com.votacion.candidatos.dto.CandidatoResponse;

public interface ICandidatoService {
	
	CandidatoResponse crear(CandidatoRequest request);
    List<CandidatoResponse> listar();
    List<CandidatoResponse> listarPorEleccion(Long eleccionId);
    CandidatoResponse obtener(Long id);
}
