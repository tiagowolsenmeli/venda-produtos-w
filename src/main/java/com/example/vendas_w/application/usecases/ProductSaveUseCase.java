package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.mappers.ProductMapper;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsOutputDTO;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ProductSaveUseCase {

    private final ProductService productService;


    public ProductsOutputDTO execute (final ProductsInputDTO productsInputDTO){
        Product product = ProductMapper.toDomain(productsInputDTO);

        Product productSaved = productService.saveProduct(product);

        return ProductMapper.fromDomain(product);

    }


}
