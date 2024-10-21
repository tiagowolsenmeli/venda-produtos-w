package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.mappers.ProductMapper;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductSearchInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@AllArgsConstructor
@Service
public class ProductSearchUseCase {

    private  final ProductService productService;
    public List<ProductOutputDTO> execute (final ProductSearchInputDTO productSearchInputDTO){
        List<Product> productList = productService.searchProducts(productSearchInputDTO.getName(), productSearchInputDTO.getFiscalCode())
                .stream()
                .sorted(Comparator.comparingLong(Product::getId))
                .toList();

        return convertToProductOutputDto(productList);

    }

    private List<ProductOutputDTO> convertToProductOutputDto (List<Product> products){
        return ProductMapper.toDTO(products);
    }


}
