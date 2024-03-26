package com.br.impostoservice.usecase.LGI;

import com.br.impostoservice.usecase.ImpostoStrategy;

public class CalculaLgiUseCase implements ImpostoStrategy {

    @Override
    public double calcular(double valor) {
        return valor * 0.50;
    }
}
