package com.votacion.elecciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.votacion.elecciones.dto.EleccionRequest;
import com.votacion.elecciones.dto.EleccionResponse;
import com.votacion.elecciones.entity.Eleccion;
import com.votacion.elecciones.repository.EleccionRepository;
import com.votacion.elecciones.exception.EleccionException;

@Service
public class EleccionServiceImpl implements IEleccionService {
	
	private final EleccionRepository repository;

    public EleccionServiceImpl(EleccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public EleccionResponse crear(EleccionRequest request) {
    	
        Eleccion eleccion = new Eleccion();

        eleccion.setNombre(request.getNombre());
        eleccion.setFechaInicio(request.getFechaInicio());
        eleccion.setFechaFin(request.getFechaFin());

        eleccion.setEstado("ACTIVA");
        repository.save(eleccion);
        return convertir(eleccion);
    }

    @Override
    public List<EleccionResponse> listar() {

        return repository.findAll().stream().map(this::convertir).toList();
    }

    @Override
    public EleccionResponse obtener(Long id) {

        Eleccion eleccion =
                repository.findById(id)
                .orElseThrow(() ->
                    new EleccionException(
                            "Elección no encontrada"));

        return convertir(eleccion);
    }
    
    private EleccionResponse convertir(Eleccion eleccion) {

        EleccionResponse response = new EleccionResponse();

        response.setId(eleccion.getId());
        response.setNombre(eleccion.getNombre());
        response.setFechaInicio(eleccion.getFechaInicio());
        response.setFechaFin(eleccion.getFechaFin());
        response.setEstado(eleccion.getEstado());

        return response;
    }
}
