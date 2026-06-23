package com.votacion.ciudadano.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.votacion.ciudadano.dto.CiudadanoRequest;
import com.votacion.ciudadano.dto.CiudadanoResponse;
import com.votacion.ciudadano.entity.Ciudadano;
import com.votacion.ciudadano.repository.CiudadanoRepository;
import com.votacion.ciudadano.exception.CiudadanoException;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	
	private final CiudadanoRepository repository;

    public CiudadanoServiceImpl(CiudadanoRepository repository) {
        this.repository = repository;
    }

    @Override
    public CiudadanoResponse crear( CiudadanoRequest request) {

        if (repository.existsByDni(request.getDni())) {
            throw new CiudadanoException("El DNI ya existe");
        }

        Ciudadano ciudadano = new Ciudadano();

        ciudadano.setDni(request.getDni());
        ciudadano.setNombres(request.getNombres());
        ciudadano.setApellidos(request.getApellidos());
        ciudadano.setCorreo(request.getCorreo());
        ciudadano.setHabilitado(request.getHabilitado());

        repository.save(ciudadano);

        return convertir(ciudadano);
    }

    @Override
    public List<CiudadanoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertir)
                .toList();
    }

    @Override
    public CiudadanoResponse obtenerPorDni(String dni) {

        Ciudadano ciudadano = repository.findByDni(dni)
				                .orElseThrow(() ->
				                        new CiudadanoException(
				                                "Ciudadano no encontrado"));
        return convertir(ciudadano);
    }

    private CiudadanoResponse convertir(Ciudadano ciudadano) {

        CiudadanoResponse response = new CiudadanoResponse();

        response.setId(ciudadano.getId());
        response.setDni(ciudadano.getDni());
        response.setNombres(ciudadano.getNombres());
        response.setApellidos(ciudadano.getApellidos());
        response.setCorreo(ciudadano.getCorreo());
        response.setHabilitado(ciudadano.getHabilitado());

        return response;
    }
}
