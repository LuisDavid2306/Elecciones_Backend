package com.votacion.resultados.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.votacion.resultados.entity.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    Optional<Resultado>findByEleccionIdAndCandidatoId(Long eleccionId,Long candidatoId);
}