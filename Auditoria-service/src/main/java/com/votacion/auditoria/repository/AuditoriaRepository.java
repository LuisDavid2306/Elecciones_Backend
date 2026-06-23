package com.votacion.auditoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.votacion.auditoria.entity.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
}