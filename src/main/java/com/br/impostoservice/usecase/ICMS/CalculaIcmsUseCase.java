package com.br.impostoservice.usecase.ICMS;

import com.br.impostoservice.usecase.ImpostoStrategy;

public class CalculaIcmsUseCase implements ImpostoStrategy {

        @Override
        public double calcular(double valor) {
            return valor * 0.10;
        }
}
