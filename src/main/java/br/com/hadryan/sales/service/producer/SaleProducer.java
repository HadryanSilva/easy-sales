package br.com.hadryan.sales.service.producer;

import br.com.hadryan.sales.dto.StockOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.stock-order.exchange}")
    private String exchange;

    @Value("${rabbitmq.stock-order.queue}")
    private String queue;

    public void sendSaleStockOrder(StockOrderDTO message) {
        rabbitTemplate.convertAndSend(exchange, queue, message);
    }

}
