package com.example.vendas_w.application.services;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.repositories.ProductsRepository;

public class ProductService {

    private ProductsRepository productsRepository;
    public Product saveProduct(Product product){
        product.validProduct();
        return productsRepository.save(product);
    }
}
