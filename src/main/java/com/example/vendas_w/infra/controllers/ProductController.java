package com.example.vendas_w.infra.controllers;

import com.example.vendas_w.application.usecases.ProductSaveUseCase;
import com.example.vendas_w.application.usecases.ProductSearchUseCase;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductSearchInputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping("/produtos")
@AllArgsConstructor
@Slf4j
@Tag(name = "ProductController", description = "Endpoint para operaçÕes com produtos")
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


    @PostMapping("/search")
    @Operation(summary = "Busca Produtos", description = "Busca produtos por fiscalCode e/ou name. Valores null dão findAll")
    @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductOutputDTO.class)))
    public ResponseEntity<List<ProductOutputDTO>> searchProduct(@Parameter(name = "ProductSearchInputDTO", description = "Dados a filtrar"
    , schema = @Schema(implementation = ProductSearchInputDTO.class)) @RequestBody ProductSearchInputDTO productSearchInputDTO) {
                return ResponseEntity.ok(productSearchUseCase.execute
                        (productSearchInputDTO));
    }

}
