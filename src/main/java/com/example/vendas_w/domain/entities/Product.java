package com.example.vendas_w.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private float price;
    private String fiscalCode;

    public Product(long id, String name, String description,
                   float price, String fiscalCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.fiscalCode = fiscalCode;
    }
}
