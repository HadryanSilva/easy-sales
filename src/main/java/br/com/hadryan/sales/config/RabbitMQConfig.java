package br.com.hadryan.sales.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.sales.queue}")
    private String salesQueue;

    @Value("${rabbitmq.sales.exchange}")
    private String salesExchange;

    @Bean
    public Queue salesQueue() {
        return new Queue(salesQueue, true);
    }

    @Bean
    public FanoutExchange salesExchange() {
        return new FanoutExchange(salesExchange);
    }

    @Bean
    public Binding salesBinding() {
        return BindingBuilder.bind(salesQueue())
                .to(salesExchange());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
