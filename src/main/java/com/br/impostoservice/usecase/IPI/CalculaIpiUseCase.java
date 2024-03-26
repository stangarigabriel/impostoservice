package com.br.impostoservice.usecase.IPI;

import com.br.impostoservice.usecase.ImpostoStrategy;

public class CalculaIpiUseCase implements ImpostoStrategy {

    @Override
    public double calcular(double valor) {
        return valor * 0.20;
    }
}

