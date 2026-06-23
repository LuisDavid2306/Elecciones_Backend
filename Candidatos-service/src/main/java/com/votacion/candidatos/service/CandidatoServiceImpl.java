package com.votacion.candidatos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.votacion.candidatos.dto.CandidatoRequest;
import com.votacion.candidatos.dto.CandidatoResponse;
import com.votacion.candidatos.entity.Candidato;
import com.votacion.candidatos.repository.CandidatoRepository;
import com.votacion.candidatos.exception.CandidatoException;

@Service
public class CandidatoServiceImpl implements ICandidatoService {
	
	private final CandidatoRepository repository;

    public CandidatoServiceImpl(CandidatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public CandidatoResponse crear(CandidatoRequest request) {

        Candidato candidato = new Candidato();
        candidato.setNombres(request.getNombres());
        candidato.setPartido(request.getPartido());
        candidato.setEleccionId(request.getEleccionId());
        repository.save(candidato);
        
        return convertir(candidato);
    }

    @Override
    public List<CandidatoResponse> listar() {

        return repository.findAll().stream().map(this::convertir).toList();
    }

    @Override
    public List<CandidatoResponse>listarPorEleccion(Long eleccionId) {
        return repository.findByEleccionId(eleccionId).stream().map(this::convertir).toList();
    }
    
    @Override
    public CandidatoResponse obtener(Long id) {
        Candidato candidato = repository.findById(id).orElseThrow(() -> new CandidatoException("Candidato no encontrado"));
        return convertir(candidato);
    }

    private CandidatoResponse convertir(Candidato candidato) {

        CandidatoResponse response = new CandidatoResponse();

        response.setId(candidato.getId());
        response.setNombres(candidato.getNombres());
        response.setPartido(candidato.getPartido());
        response.setEleccionId(candidato.getEleccionId());

        return response;
    }
}
