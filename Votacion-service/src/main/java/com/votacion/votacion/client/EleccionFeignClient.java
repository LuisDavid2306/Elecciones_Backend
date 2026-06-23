package com.votacion.votacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.votacion.votacion.dto.EleccionResponse;

@FeignClient(name = "ELECCIONES-SERVICE")
public interface EleccionFeignClient {
	
	@GetMapping("/api/elecciones/{id}")
    EleccionResponse obtener(@PathVariable Long id);
	
}
