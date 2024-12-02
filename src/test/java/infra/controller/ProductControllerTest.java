package infra.controller;

import com.example.vendas_w.VendasWApplication;
import com.example.vendas_w.application.services.ProductService;
import com.example.vendas_w.application.usecases.ProductSaveUseCase;
import com.example.vendas_w.application.usecases.ProductSearchUseCase;
import com.example.vendas_w.domain.entities.Product;
import com.example.vendas_w.infra.controllers.ProductController;
import com.example.vendas_w.infra.controllers.dtos.ProductOutputDTO;
import com.example.vendas_w.infra.controllers.dtos.ProductSearchInputDTO;
import com.example.vendas_w.infra.repositories.ProductsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = VendasWApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ProductControllerTest{
    @Autowired
    private ProductController target;

    @SpyBean
    private ProductSearchUseCase productSearchUseCase;
    @SpyBean
    private ProductSaveUseCase productSaveUseCase;

    @SpyBean
    private ProductService productService;

    @SpyBean
    private ProductsRepository productsRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getSimpleReturnMocked(){
        //given
        ProductSearchInputDTO productSearchInputDTO = new ProductSearchInputDTO("nome", "6904");
        String name1 = "produto 1";
        String description1 = "description do produto 1";
        BigDecimal price1 = java.math.BigDecimal.valueOf(80);
        String fiscalCode1 = "5904";

        String name2 = "produto 2";
        String description2 = "description do produto 2";
        BigDecimal price2 = java.math.BigDecimal.valueOf(100);
        String fiscalCode2 = "5949";

        Product product1 = new Product(1L, name1, description1, price1, fiscalCode1);
        Product product2 = new Product(3L,name2, description2, price2, fiscalCode2);

        ProductOutputDTO productOutputDTO1 = new ProductOutputDTO(1L,name1, description1, price1, fiscalCode1 );
        ProductOutputDTO productOutputDTO2 = new ProductOutputDTO(3L, name2, description2, price2, fiscalCode2);

        ResponseEntity<List<ProductOutputDTO>> expected = ResponseEntity.ok(List.of(productOutputDTO1, productOutputDTO2));
        List<Product> productListReturned = List.of(product1,product2);


        when(productService.searchProducts("nome","6904")).thenReturn(productListReturned);

        //when
        ResponseEntity<List<ProductOutputDTO>> result =  target.searchProduct(productSearchInputDTO);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @Disabled
    public void getSimpleReturnMockedIntegration() throws Exception {
        //given
        ProductSearchInputDTO productSearchInputDTO = new ProductSearchInputDTO("produto 1", "5904");
        String productSearchInputDTOJson = objectMapper.writeValueAsString(productSearchInputDTO);

        String name1 = "produto 1";
        String description1 = "description do produto 1";
        BigDecimal price1 = java.math.BigDecimal.valueOf(80);
        String fiscalCode1 = "5904";

        String name2 = "produto 2";
        String description2 = "description do produto 2";
        BigDecimal price2 = java.math.BigDecimal.valueOf(100);
        String fiscalCode2 = "5949";

        Product product1 = new Product(17L, name1, description1, price1, fiscalCode1);
        Product product2 = new Product(3L,name2, description2, price2, fiscalCode2);

        productsRepository.save(product1);
        productsRepository.save(product2);

        String expectedJson = "[{\"id\":1,\"nome\":\"produto 1\",\"descricao\":\"description do produto 1\",\"preco\":80.00,\"CFOP\":\"5904\"}]";

        //when
        MvcResult result = mockMvc.perform(get("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productSearchInputDTOJson))
                .andExpect(status().isOk())
                .andReturn()
        ;
        //then
        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());

        verify(productsRepository, times(1)).findByNameAndFiscalCode(anyString(), anyString());
    }

}
