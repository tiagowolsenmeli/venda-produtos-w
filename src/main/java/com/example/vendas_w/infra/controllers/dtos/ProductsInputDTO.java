package com.example.vendas_w.infra.controllers.dtos;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProductsInputDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private String fiscalCode;
}
