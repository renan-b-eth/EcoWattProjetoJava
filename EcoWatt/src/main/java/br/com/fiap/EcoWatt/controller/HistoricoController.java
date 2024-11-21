package br.com.fiap.EcoWatt.controller;

import br.com.fiap.EcoWatt.beans.Historico;
import br.com.fiap.EcoWatt.repository.HistoricoMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoMensalRepository historicoRepository;

    @GetMapping("/{id}/consumo")
    public Double getConsumoTotalById(@PathVariable Long id) {
        Optional<Historico> historico = historicoRepository.findById(id);
        return historico.map(Historico::getConsumoTotal).orElse(null);
    }
}