package com.votacion.votacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.votacion.votacion.dto.CandidatoResponse;

@FeignClient(name = "CANDIDATOS-SERVICE")
public interface CandidatoFeignClient {
	@GetMapping("/api/candidatos/{id}")
    CandidatoResponse obtener(@PathVariable Long id);
}
