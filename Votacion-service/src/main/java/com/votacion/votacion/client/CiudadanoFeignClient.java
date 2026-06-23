package com.votacion.votacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.votacion.votacion.dto.CiudadanoResponse;

@FeignClient(name = "CIUDADANO-SERVICE")
public interface CiudadanoFeignClient {
	
	@GetMapping("/api/ciudadanos/{dni}")
    CiudadanoResponse obtenerPorDni(@PathVariable String dni);
}
