package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.ProductSaveUseCase;
import com.example.vendas_w.application.usecases.ProductSearchUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductSearchInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@Slf4j
public class ProductController {


    private final  ProductSaveUseCase productSaveUseCase;

    private  final ProductSearchUseCase productSearchUseCase;

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


    @GetMapping
    public ResponseEntity<List<ProductOutputDTO>> searchProduct(@RequestBody ProductSearchInputDTO productSearchInputDTO) {
                return ResponseEntity.ok(productSearchUseCase.execute
                        (productSearchInputDTO));
    }

}
