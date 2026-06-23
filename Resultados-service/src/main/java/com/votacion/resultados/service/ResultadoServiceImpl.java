package com.votacion.resultados.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.votacion.resultados.dto.ResultadoResponse;
import com.votacion.resultados.entity.Resultado;
import com.votacion.resultados.repository.ResultadoRepository;
import java.util.Optional;
import com.votacion.resultados.event.VotoEvent;

@Service
public class ResultadoServiceImpl
        implements IResultadoService {

    private final ResultadoRepository repository;

    public ResultadoServiceImpl(
            ResultadoRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<ResultadoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertir)
                .toList();
    }

    @Override
    public void registrarVoto(VotoEvent event) {

        Optional<Resultado> resultadoExistente =
                repository.findByEleccionIdAndCandidatoId(
                        event.getEleccionId(),
                        event.getCandidatoId());

        if (resultadoExistente.isPresent()) {

            Resultado resultado =
                    resultadoExistente.get();

            resultado.setTotalVotos(
                    resultado.getTotalVotos() + 1);

            repository.save(resultado);

        } else {

            Resultado resultado = new Resultado();

            resultado.setEleccionId(
                    event.getEleccionId());

            resultado.setCandidatoId(
                    event.getCandidatoId());

            resultado.setTotalVotos(1);

            repository.save(resultado);
        }
    }
    
    private ResultadoResponse convertir(
            Resultado resultado) {

        ResultadoResponse response =
                new ResultadoResponse();

        response.setId(resultado.getId());
        response.setEleccionId(
                resultado.getEleccionId());

        response.setCandidatoId(
                resultado.getCandidatoId());

        response.setTotalVotos(
                resultado.getTotalVotos());

        return response;
    }
}
