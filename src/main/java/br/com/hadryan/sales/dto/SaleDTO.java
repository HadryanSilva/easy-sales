package br.com.hadryan.sales.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDTO {

    private Long productId;
    private Long userId;
    private Integer quantity;
    private Double price;
    private Double total;

}
