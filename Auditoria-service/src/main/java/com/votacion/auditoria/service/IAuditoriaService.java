package com.votacion.auditoria.service;

import java.util.List;
import com.votacion.auditoria.dto.AuditoriaResponse;
import com.votacion.auditoria.event.VotoEvent;

public interface IAuditoriaService {
    List<AuditoriaResponse> listar();
    void registrarVoto(VotoEvent event);
}