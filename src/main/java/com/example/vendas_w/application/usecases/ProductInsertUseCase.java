package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.services.ValidateProductService;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsOutputDTO;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ProductInsertUseCase {

    private final ValidateProductService validateProductService;


    public ProductsOutputDTO execute (final ProductsInputDTO productsInputDTO){

        return new ProductsOutputDTO(1);
    }
}
