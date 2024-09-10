package com.example.vendas_w.application.services;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;

    public Product saveProduct(Product product){
        product.validProduct();
        return productsRepository.save(product);
    }
}
