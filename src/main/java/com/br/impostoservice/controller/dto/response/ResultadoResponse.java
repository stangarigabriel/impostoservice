package com.br.impostoservice.controller.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResultadoResponse {
    private String nome;
    private BigDecimal valor;
}
