package com.example.vendas_w.infra.controllers.dtos.sales;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class SaleInputDTO {
    private long  idProduto;
    private String description;
    private BigDecimal price;
    private String fiscalCode;
}
