package com.votacion.auditoria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.votacion.auditoria.event.VotoEvent;
import com.votacion.auditoria.service.IAuditoriaService;

@Component
public class AuditoriaConsumer {

    private final IAuditoriaService auditoriaService;

    public AuditoriaConsumer(
            IAuditoriaService auditoriaService) {

        this.auditoriaService = auditoriaService;
    }

    @RabbitListener(queues = "auditoria.queue")
    public void recibir(VotoEvent event) {

        System.out.println(
                "AUDITORIA RECIBIO -> DNI: "
                + event.getDni()
                + " Eleccion: "
                + event.getEleccionId()
                + " Candidato: "
                + event.getCandidatoId());

        auditoriaService.registrarVoto(event);
    }
}