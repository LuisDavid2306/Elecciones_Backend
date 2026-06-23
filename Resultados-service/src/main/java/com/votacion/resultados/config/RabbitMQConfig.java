package com.votacion.resultados.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "votos.exchange";
    public static final String QUEUE = "resultados.queue";
    public static final String ROUTING_KEY = "resultados";

    @Bean
    public Queue resultadosQueue() {
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(
            Queue resultadosQueue,
            DirectExchange exchange) {

        return BindingBuilder
                .bind(resultadosQueue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}