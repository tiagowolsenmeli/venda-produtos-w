package com.example.vendas_w.infra.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductsInputDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private String fiscalCode;
}
