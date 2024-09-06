package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.ProductSaveUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsOutputDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/produtos")
public class ProductsController {


    private ProductSaveUseCase productSaveUseCase;

    @PostMapping
    public ResponseEntity<ProductsOutputDTO> insertNewProducts (@RequestBody ProductsInputDTO productsInputDTO) {

        try {
            return ResponseEntity.ok(productSaveUseCase.execute(productsInputDTO));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
