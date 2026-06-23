package com.votacion.votacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votacion.votacion.entity.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	boolean existsByDniAndEleccionId(String dni, Long eleccionId);
}
