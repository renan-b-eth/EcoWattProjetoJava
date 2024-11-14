package br.com.fiap.EcoWatt.controller;

import br.com.fiap.EcoWatt.beans.Consumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ConsumoController {
    private final Random random = new Random();

    @GetMapping("/consumo")
    public ResponseEntity<Consumo> getConsumo() throws InterruptedException {
        Thread.sleep(1000); // Aguarda 1 segundo
        Consumo consumo = new Consumo();
        consumo.setPotencia(random.nextDouble() * 1000); // Potência entre 0 e 1000W
        consumo.setTensao(random.nextDouble() * 250); // Tensão entre 0 e 250V
        consumo.setCorrente(random.nextDouble() * 10); // Corrente entre 0 e 10A
        // Cálculo do consumo atual (simplificado para demonstração)
        consumo.setConsumoAtual(consumo.getPotencia() * 0.001);

        return ResponseEntity.ok(consumo);
    }
}
