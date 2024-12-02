package com.example.vendas_w.infra.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchInputDTO {
    @JsonProperty("nome")
    private String name;
    @JsonProperty("CFOP")
    private String fiscalCode;
}
