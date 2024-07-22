package br.com.hadryan.sales.service.consumer;

import br.com.hadryan.sales.dto.SaleDTO;
import br.com.hadryan.sales.dto.StockOrderDTO;
import br.com.hadryan.sales.mapper.SaleMapper;
import br.com.hadryan.sales.repository.SaleRepository;
import br.com.hadryan.sales.service.producer.SaleProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class SaleConsumer {

    private final SaleProducer saleProducer;

    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper;

    @RabbitListener(queues = "${rabbitmq.sales.queue}")
    public void createSale(SaleDTO saleDTO) {
        log.info("Creating sale: {}", saleDTO);
        var sale = saleMapper.toEntity(saleDTO);
        sale.setCreatedAt(LocalDateTime.now());
        saleRepository.save(sale);
        log.info("Sending sale stock order: {}", saleDTO);
        sendSaleStockOrder(saleDTO);
    }

    private void sendSaleStockOrder(SaleDTO saleDTO) {
        StockOrderDTO stockOrderDTO = new StockOrderDTO();
        stockOrderDTO.setProductId(saleDTO.getProductId());
        stockOrderDTO.setQuantity(saleDTO.getQuantity());
        saleProducer.sendSaleStockOrder(stockOrderDTO);
    }

}
