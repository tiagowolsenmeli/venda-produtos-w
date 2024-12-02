package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.mappers.ProductMapper;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductsInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@AllArgsConstructor
@Service
public class SaleProductUseCase {

    private final ProductService productService;
    public List<ProductOutputDTO> execute (final ProductsInputDTO productsInputDTO){
        List<Product> productList = productService.searchProducts(productsInputDTO.getName(),
                        productsInputDTO.getFiscalCode())
                .stream()
                .sorted(Comparator.comparingLong(Product::getId))
                .toList();

        return convertToProductOutputDto(productList);

    }

    private List<ProductOutputDTO> convertToProductOutputDto (List<Product> products){
        return ProductMapper.toDTO(products);
    }

}
