package com.br.impostoservice.controller;

import com.br.impostoservice.controller.CalculaImpostoController;
import com.br.impostoservice.usecase.CalculadoraimpostoUseCase;
import com.br.impostoservice.usecase.ICMS.CalculaIcmsUseCase;
import com.br.impostoservice.usecase.IPI.CalculaIpiUseCase;
import com.br.impostoservice.usecase.LGI.CalculaLgiUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculaImpostoControllerTest {

    @Mock
    private CalculadoraimpostoUseCase useCaseMock;

    public CalculaImpostoControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalcularImpostoICMS() {
        CalculaImpostoController controller = new CalculaImpostoController();
        controller.useCase = useCaseMock;

        double valor = 100.0;
        double resultadoEsperado = 10.0;

        when(useCaseMock.calcular(valor)).thenReturn(resultadoEsperado);

        String resultado = controller.calcularImposto("ICMS", valor);

        assertEquals("O imposto calculado para ICMS com o valor 100.0 é: 10.0", resultado);
        verify(useCaseMock, times(1)).setImpostoStrategy(any(CalculaIcmsUseCase.class));
        verify(useCaseMock, times(1)).calcular(valor);
    }

}
