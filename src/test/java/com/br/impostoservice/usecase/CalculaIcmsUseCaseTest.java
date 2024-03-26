package com.br.impostoservice.usecase;

import com.br.impostoservice.usecase.ICMS.CalculaIcmsUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculaIcmsUseCaseTest {

    @Test
    public void testCalcular() {
        // Arrange
        double valor = 100.0;
        CalculaIcmsUseCase calculaIcmsUseCase = new CalculaIcmsUseCase();

        // Act
        double resultado = calculaIcmsUseCase.calcular(valor);

        // Assert
        assertEquals(10.0, resultado); // 100 * 0.10 = 10.0
    }

}
