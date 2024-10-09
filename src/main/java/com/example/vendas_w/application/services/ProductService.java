package com.example.vendas_w.application.services;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;

    public Product saveProduct(Product product){
        product.validProduct();
        return productsRepository.save(product);
    }

    public List<Product> searchProducts(String name, String fiscalCode){

        if (isFindAll(name, fiscalCode)) {
            return productsRepository.findAll();
        }

        if (name != null && fiscalCode == null) {
            return productsRepository.findByName(name);
        }

        if (name == null && fiscalCode != null) {
            return productsRepository.findByFiscalCode(fiscalCode);
            //TODO FiscalCode só retornar um
        }

        return null;
    }

    private static boolean isFindAll(String name, String fiscalCode) {
        return name == null && fiscalCode == null;
    }
}
