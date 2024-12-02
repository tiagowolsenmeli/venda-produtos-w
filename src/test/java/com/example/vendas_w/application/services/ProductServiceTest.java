package com.example.vendas_w.application.services;

import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.repositories.ProductsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService target;

    @Mock
    private ProductsRepository productsRepository;

    @Test
    void searchProductsFindAll() {
        //given
        String nameInput = null;
        String fiscalCodeInput = null;
        Product product = new Product(1L, "", "", BigDecimal.ZERO, "");
        Product productExpected = new Product(1L, "", "", BigDecimal.ZERO, "");
        List<Product> expected = List.of(productExpected);

        when(productsRepository.findAll())
                .thenReturn(List.of(product));

        //then
        List<Product> productListReturned = target.searchProducts(nameInput, fiscalCodeInput);

        //when
        Assertions.assertEquals(expected, productListReturned);
    }

    @Test
    void searchProductsFindByName() {
        //given
        String nameInput = "nameValid";
        String fiscalCodeInput = null;
        Product product = new Product(1L, "", "", BigDecimal.ZERO, "");
        Product productExpected = new Product(1L, "", "", BigDecimal.ZERO, "");
        List<Product> expected = List.of(productExpected);

        when(productsRepository.findByName(nameInput))
                .thenReturn(List.of(product));

        //then
        List<Product> productListReturned = target.searchProducts(nameInput, fiscalCodeInput);

        //when
        Assertions.assertEquals(expected, productListReturned);
    }

    @Test
    void searchProductsFindByFiscalCode() {
        //given
        String nameInput = null;
        String fiscalCodeInput = "1234";
        Product product = new Product(1L, "", "", BigDecimal.ZERO, "");
        Product productExpected = new Product(1L, "", "", BigDecimal.ZERO, "");
        List<Product> expected = List.of(productExpected);

        when(productsRepository.findByFiscalCode(fiscalCodeInput))
                .thenReturn(List.of(product));

        //then
        List<Product> productListReturned = target.searchProducts(nameInput, fiscalCodeInput);

        //when
        Assertions.assertEquals(expected, productListReturned);
    }

}