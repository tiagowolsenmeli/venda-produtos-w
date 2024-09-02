package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.ProductInsertUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsOutputDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/produtos")
public class ProductsController {


    private ProductInsertUseCase productInsertUseCase;

    @PostMapping
    public ProductsOutputDTO insertNewProducts (@RequestBody ProductsInputDTO productsInputDTO){
        return productInsertUseCase.execute(productsInputDTO);
    }

}
