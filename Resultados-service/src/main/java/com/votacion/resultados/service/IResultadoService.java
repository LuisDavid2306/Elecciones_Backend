package com.votacion.resultados.service;

import java.util.List;
import com.votacion.resultados.dto.ResultadoResponse;
import com.votacion.resultados.event.VotoEvent;

public interface IResultadoService {
    List<ResultadoResponse> listar();
    void registrarVoto(VotoEvent event);
}
