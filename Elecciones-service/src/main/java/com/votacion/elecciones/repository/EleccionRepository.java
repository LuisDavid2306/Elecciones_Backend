package com.votacion.elecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votacion.elecciones.entity.Eleccion;

public interface EleccionRepository extends JpaRepository<Eleccion, Long> {

}
