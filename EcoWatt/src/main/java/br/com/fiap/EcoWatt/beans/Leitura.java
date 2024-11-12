package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "ECOWATT_LEITURA_CONSUMO")
public class Leitura {
    @Column(name = "ID_LEITURA")
    int idLeitura;
    @Column(name = "CORRENTE_LEITURA")
    double correnteLeitura;
    @Column(name = "TENSAO_LEITURA")
    double tensaoLeitura;
    @Column(name = "POTENCIA_LEITURA")
    double potencialLeitura;
    @Column(name = "DATA_HORA")
    String dataLeitura;
    @Column(name = "ID_DISPOSITIVO")
    int idDispositivo;
}
