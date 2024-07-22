package br.com.hadryan.sales.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StockOrderDTO {

    private Long productId;
    private Integer quantity;
    private LocalDateTime createdAt;

}
