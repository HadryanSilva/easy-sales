package br.com.hadryan.sales.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SaleDTO {

    private Long productId;
    private Long userId;
    private Integer quantity;
    private Double price;
    private Double total;
    private LocalDateTime createdAt;

}
