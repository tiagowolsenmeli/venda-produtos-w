package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.ProductSaveUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@Slf4j
public class ProductController {


    private final  ProductSaveUseCase productSaveUseCase;

    @PostMapping
    public ResponseEntity<ProductOutputDTO> insertProduct(@RequestBody ProductsInputDTO productsInputDTO) {

        try {
            return ResponseEntity.ok(productSaveUseCase.execute(productsInputDTO));
        }catch (IllegalArgumentException illegalArgumentException){
            log.error(illegalArgumentException.getMessage());
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}
