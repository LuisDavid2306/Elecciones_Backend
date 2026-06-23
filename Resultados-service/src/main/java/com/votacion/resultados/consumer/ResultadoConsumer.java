package com.votacion.resultados.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.votacion.resultados.event.VotoEvent;
import com.votacion.resultados.service.IResultadoService;

@Component
public class ResultadoConsumer {

    private final IResultadoService resultadoService;

    public ResultadoConsumer(
            IResultadoService resultadoService) {

        this.resultadoService = resultadoService;
    }

    @RabbitListener(queues = "resultados.queue")
    public void recibir(VotoEvent event) {

        System.out.println(
                "RESULTADO RECIBIO -> DNI: "
                + event.getDni());

        resultadoService.registrarVoto(event);
    }
}