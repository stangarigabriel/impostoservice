package com.br.impostoservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
@RequiredArgsConstructor
public class CalculadoraimpostoUseCase {

    private ImpostoStrategy impostoStrategy;

    public double calcular(double valor) {
            if (impostoStrategy != null) {
                return impostoStrategy.calcular(valor);
            }
            return valor;
        }
}
