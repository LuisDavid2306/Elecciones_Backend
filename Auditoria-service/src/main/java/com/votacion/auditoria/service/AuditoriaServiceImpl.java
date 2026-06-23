package com.votacion.auditoria.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.votacion.auditoria.dto.AuditoriaResponse;
import com.votacion.auditoria.entity.Auditoria;
import com.votacion.auditoria.event.VotoEvent;
import com.votacion.auditoria.repository.AuditoriaRepository;

@Service
public class AuditoriaServiceImpl implements IAuditoriaService {

    private final AuditoriaRepository repository;

    public AuditoriaServiceImpl(AuditoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AuditoriaResponse> listar() {
        return repository.findAll().stream().map(this::convertir).toList();
    }
    
    @Override
    public void registrarVoto(VotoEvent event) {

        Auditoria auditoria = new Auditoria();

        auditoria.setDni(event.getDni());
        auditoria.setEleccionId(event.getEleccionId());
        auditoria.setCandidatoId(event.getCandidatoId());
        auditoria.setFechaRegistro(LocalDateTime.now());

        repository.save(auditoria);
    }

    private AuditoriaResponse convertir(Auditoria auditoria) {

        AuditoriaResponse response =new AuditoriaResponse();

        response.setId(auditoria.getId());
        response.setDni(auditoria.getDni());
        response.setEleccionId(auditoria.getEleccionId());
        response.setCandidatoId(auditoria.getCandidatoId());
        response.setFechaRegistro(auditoria.getFechaRegistro());

        return response;
    }
}