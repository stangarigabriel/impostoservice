package com.br.impostoservice.usecase;

import com.br.impostoservice.usecase.CalculadoraimpostoUseCase;
import com.br.impostoservice.usecase.ImpostoStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadoraimpostoUseCaseTest {

    @Mock
    private ImpostoStrategy impostoStrategyMock;

    public CalculadoraimpostoUseCaseTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalcularComImpostoStrategy() {
        // Arrange
        double valor = 100.0;
        double resultadoEsperado = 50.0;
        CalculadoraimpostoUseCase calculadora = new CalculadoraimpostoUseCase();
        calculadora.setImpostoStrategy(impostoStrategyMock);

        // Configurando comportamento do impostoStrategyMock
        when(impostoStrategyMock.calcular(valor)).thenReturn(resultadoEsperado);

        // Act
        double resultado = calculadora.calcular(valor);

        // Assert
        assertEquals(resultadoEsperado, resultado);
        // Verifique se o método calcular do impostoStrategyMock foi chamado uma vez com o valor correto
        verify(impostoStrategyMock, times(1)).calcular(valor);
    }

    @Test
    public void testCalcularSemImpostoStrategy() {
        // Arrange
        double valor = 100.0;
        CalculadoraimpostoUseCase calculadora = new CalculadoraimpostoUseCase();

        // Act
        double resultado = calculadora.calcular(valor);

        // Assert
        assertEquals(valor, resultado);
        // Verifique se o método calcular do impostoStrategyMock NÃO foi chamado
        verify(impostoStrategyMock, never()).calcular(anyDouble());
    }

}
