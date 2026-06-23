package com.votacion.elecciones.service;

import java.util.List;

import com.votacion.elecciones.dto.EleccionRequest;
import com.votacion.elecciones.dto.EleccionResponse;

public interface IEleccionService {
	EleccionResponse crear(EleccionRequest request);
    List<EleccionResponse> listar();
    EleccionResponse obtener(Long id);
}
