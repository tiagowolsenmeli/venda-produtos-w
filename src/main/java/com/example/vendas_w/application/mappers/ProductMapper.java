package com.example.vendas_w.application.mappers;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsOutputDTO;
import org.springframework.stereotype.Component;


public class ProductMapper {

    public static Product toDomain (ProductsInputDTO productsInputDTO){
        return new Product(null, productsInputDTO.getName(), productsInputDTO.getDescription(), productsInputDTO.getPrice(),
                productsInputDTO.getFiscalCode());
    }

    public static ProductsOutputDTO fromDomain (Product product){
        return new ProductsOutputDTO(product.getId());
    }

}
