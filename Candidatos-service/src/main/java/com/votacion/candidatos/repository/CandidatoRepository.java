package com.votacion.candidatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votacion.candidatos.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	
	List<Candidato> findByEleccionId(Long eleccionId);
	
}
