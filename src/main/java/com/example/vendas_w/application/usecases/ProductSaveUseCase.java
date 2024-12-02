package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.mappers.ProductMapper;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ProductSaveUseCase {

    private final ProductService productService;


    public ProductOutputDTO execute (final ProductsInputDTO productsInputDTO){
        Product product = ProductMapper.toDomain(productsInputDTO);

        Product productSaved = productService.saveProduct(product);

        return ProductMapper.toDTO(product);

    }


}
