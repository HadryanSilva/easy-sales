package br.com.hadryan.sales.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockOrderDTO {

    private Long productId;
    private Integer quantity;

}
