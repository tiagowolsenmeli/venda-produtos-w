package com.example.vendas_w.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String fiscalCode;

    public Product(final Long id, final String name, final String description,
                   final BigDecimal price, final String fiscalCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.fiscalCode = fiscalCode;
    }

    public void validProduct() {

        if (this.name == null || this.name.isBlank() || this.name.length() < 10) {
            throw new IllegalArgumentException("Nome do produto inválido");
        }
        if (this.fiscalCode == null || this.fiscalCode.isBlank() || this.fiscalCode.length() != 4) {
            throw new IllegalArgumentException("CFOP inválido!");
        }

    }
}
