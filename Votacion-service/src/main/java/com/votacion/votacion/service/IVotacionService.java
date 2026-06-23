package com.votacion.votacion.service;

import java.util.List;

import com.votacion.votacion.dto.VotoRequest;
import com.votacion.votacion.dto.VotoResponse;

public interface IVotacionService {
	VotoResponse votar(VotoRequest request);
    List<VotoResponse> listar();
}
