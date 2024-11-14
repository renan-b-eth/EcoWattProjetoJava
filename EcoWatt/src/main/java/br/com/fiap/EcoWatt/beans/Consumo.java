package br.com.fiap.EcoWatt.beans;

import lombok.Data;

@Data
public class Consumo {
    private double potencia;
    private double tensao;
    private double corrente;
    private double consumoAtual;
}
