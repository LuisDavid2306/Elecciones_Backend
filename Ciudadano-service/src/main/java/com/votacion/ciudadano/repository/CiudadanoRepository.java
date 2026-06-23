package com.votacion.ciudadano.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votacion.ciudadano.entity.Ciudadano;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Long> {
	
	Optional<Ciudadano> findByDni(String dni);
    boolean existsByDni(String dni);
    
}
