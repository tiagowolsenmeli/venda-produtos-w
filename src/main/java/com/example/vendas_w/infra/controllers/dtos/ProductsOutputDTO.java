package com.example.vendas_w.infra.controllers.dtos;

import java.math.BigDecimal;

public class ProductsOutputDTO {
    public ProductsOutputDTO(long id) {
        this.id = id;
    }

    private long id;
    private  String message;
}
