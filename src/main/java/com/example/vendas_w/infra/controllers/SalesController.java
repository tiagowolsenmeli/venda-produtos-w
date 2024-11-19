package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.SaleProductUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venda")
@AllArgsConstructor
@Slf4j
@Tag(name = "SalesController", description = "Endpoint para venda de produtos")
public class SalesController {


    private final SaleProductUseCase saleProductUseCase;

    @PostMapping
    public ResponseEntity<List<ProductOutputDTO>> saleProduct(@RequestBody ProductsInputDTO productsInputDTO) {
        try {

            List<ProductOutputDTO> produtosRetornados = saleProductUseCase.execute(productsInputDTO);
            return ResponseEntity.ok(produtosRetornados);


        }catch (IllegalArgumentException illegalArgumentException){
            log.error(illegalArgumentException.getMessage());
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}
