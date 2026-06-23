package com.votacion.votacion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.votacion.votacion.client.CandidatoFeignClient;
import com.votacion.votacion.client.CiudadanoFeignClient;
import com.votacion.votacion.client.EleccionFeignClient;
import com.votacion.votacion.dto.CandidatoResponse;
import com.votacion.votacion.dto.CiudadanoResponse;
import com.votacion.votacion.dto.EleccionResponse;
import com.votacion.votacion.dto.VotoRequest;
import com.votacion.votacion.dto.VotoResponse;
import com.votacion.votacion.entity.Voto;
import com.votacion.votacion.exception.VotacionException;
import com.votacion.votacion.repository.VotoRepository;

@Service
public class VotacionServiceImpl implements IVotacionService {
	
	private final VotoRepository repository;
	
	private final CiudadanoFeignClient ciudadanoClient;
	private final EleccionFeignClient eleccionClient;
	private final CandidatoFeignClient candidatoClient;

	public VotacionServiceImpl(VotoRepository repository, CiudadanoFeignClient ciudadanoClient, EleccionFeignClient eleccionClient, CandidatoFeignClient candidatoClient) {
	    this.repository = repository;
	    this.ciudadanoClient = ciudadanoClient;
	    this.eleccionClient = eleccionClient;
	    this.candidatoClient = candidatoClient;
	}

    @Override
    public VotoResponse votar(VotoRequest request) {

    	CiudadanoResponse ciudadano = ciudadanoClient.obtenerPorDni(request.getDni());
    	
    	if (!Boolean.TRUE.equals(ciudadano.getHabilitado())) {
    	    throw new VotacionException("Ciudadano no habilitado para votar");
    	}
    	
    	EleccionResponse eleccion = eleccionClient.obtener(request.getEleccionId());
    	
    	if (!"ACTIVA".equals(eleccion.getEstado())) {
    	    throw new VotacionException("La elección no está activa");
    	}
    	
    	CandidatoResponse candidato = candidatoClient.obtener(request.getCandidatoId());
    	
    	if (!candidato.getEleccionId().equals(request.getEleccionId())) {
    	    throw new VotacionException("El candidato no pertenece a la elección");
    	}
    	
        if (repository.existsByDniAndEleccionId(request.getDni(),request.getEleccionId())) {
            throw new VotacionException("El ciudadano ya votó");
        }
        
        Voto voto = new Voto();
        
        voto.setDni(request.getDni());
        voto.setEleccionId(request.getEleccionId());
        voto.setCandidatoId(request.getCandidatoId());
        voto.setFechaVoto(LocalDateTime.now());
        
        repository.save(voto);
        
        return convertir(voto);
    }

    @Override
    public List<VotoResponse> listar() {
        return repository.findAll().stream().map(this::convertir).toList();
    }

    private VotoResponse convertir(Voto voto) {

        VotoResponse response = new VotoResponse();

        response.setId(voto.getId());
        response.setDni(voto.getDni());
        response.setEleccionId(voto.getEleccionId());
        response.setCandidatoId(voto.getCandidatoId());
        response.setFechaVoto(voto.getFechaVoto());

        return response;
    }
}
