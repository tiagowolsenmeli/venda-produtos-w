package com.example.vendas_w.application.mappers;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;


public class ProductMapper {

    public static Product toDomain (ProductsInputDTO productsInputDTO){
        return new Product(null, productsInputDTO.getName(), productsInputDTO.getDescription(), productsInputDTO.getPrice(),
                productsInputDTO.getFiscalCode());
    }

    public static ProductOutputDTO fromDomain (Product product){
        final ProductOutputDTO productOutputDTO = new ProductOutputDTO();
        productOutputDTO.setId(product.getId());
        productOutputDTO.setName(product.getName());
        productOutputDTO.setPrice(product.getPrice());
        productOutputDTO.setDescription(product.getDescription());
        productOutputDTO.setFiscalCode(product.getFiscalCode());

        return productOutputDTO;
    }

}
