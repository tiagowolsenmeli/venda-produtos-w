package com.example.vendas_w.infra.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutputDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("descricao")
    private String description;
    @JsonProperty("preco")
    private BigDecimal price;
    @JsonProperty("CFOP")
    private String fiscalCode;
}
