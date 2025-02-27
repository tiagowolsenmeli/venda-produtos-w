package com.example.vendas_w.application.usecases;

import com.example.vendas_w.application.mappers.ProductMapper;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductSearchInputDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductSearchUseCaseTest {

    @Mock
    private  ProductService productService;

    @InjectMocks
    private  ProductSearchUseCase target;


    @Test
    void testExecuteSearch2ProductAndSortById() {
        final String nameInput = "produto1";
        final String fiscalCode = "fiscalCode1";

        Product product1 = new Product();
        product1.setName("produto1");
        product1.setId(2L);
        product1.setFiscalCode("fiscalCode1");

        Product product2 = new Product();
        product2.setName("produto2");
        product2.setId(1L);
        product2.setFiscalCode("fiscalCode2");

        ProductSearchInputDTO productSearchInputDTO = new ProductSearchInputDTO();
        productSearchInputDTO.setName(nameInput);
        productSearchInputDTO.setFiscalCode(fiscalCode);

        final List<Product> returnService = List.of(product1, product2);
        final List<Product> expectedList = List.of(product2, product1);
        List<ProductOutputDTO> expected = ProductMapper.toDTO(expectedList);


        when(productService.searchProducts(nameInput, fiscalCode)).thenReturn(returnService);

        List<ProductOutputDTO> productOutputDTOS = target.execute(productSearchInputDTO);

        Assertions.assertEquals(expected, productOutputDTOS);
    }
}