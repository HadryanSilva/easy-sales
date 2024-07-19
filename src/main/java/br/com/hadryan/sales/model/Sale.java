package br.com.hadryan.sales.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double total;

}
