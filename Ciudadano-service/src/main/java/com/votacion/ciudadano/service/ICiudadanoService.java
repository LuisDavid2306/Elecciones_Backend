package com.votacion.ciudadano.service;

import java.util.List;

import com.votacion.ciudadano.dto.CiudadanoRequest;
import com.votacion.ciudadano.dto.CiudadanoResponse;

public interface ICiudadanoService {
	
	CiudadanoResponse crear(CiudadanoRequest request);
    List<CiudadanoResponse> listar();
    CiudadanoResponse obtenerPorDni(String dni);
    
}
