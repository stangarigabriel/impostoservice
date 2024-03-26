package com.br.impostoservice.controller;

import com.br.impostoservice.usecase.CalculadoraimpostoUseCase;
import com.br.impostoservice.usecase.ICMS.CalculaIcmsUseCase;
import com.br.impostoservice.usecase.IPI.CalculaIpiUseCase;
import com.br.impostoservice.usecase.LGI.CalculaLgiUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalculaImpostoController {

@Autowired
public CalculadoraimpostoUseCase useCase;
    @GetMapping("/calcular_imposto")
    public String calcularImposto(@RequestParam(value = "imposto") String imposto,
                                  @RequestParam(value = "valor") double valor) {

        switch (imposto) {
            case "ICMS":
                useCase.setImpostoStrategy(new CalculaIcmsUseCase());
                break;
            case "IPI":
                useCase.setImpostoStrategy(new CalculaIpiUseCase());
                break;
            case "LGI":
                useCase.setImpostoStrategy(new CalculaLgiUseCase());
                break;
            default:
                return "Imposto não suportado";
        }

        double resultado = useCase.calcular(valor);
        return "O imposto calculado para " + imposto + " com o valor " + valor + " é: " + resultado;
    }

}
