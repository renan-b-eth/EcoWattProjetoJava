package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOWATT_HISTORICO_MENSAL")
public class Historico {
    @Id
    @Column(name = "ID_HISTORICO")
    int idHistorico;
    @Column(name = "ID_DISPOSITIVO")
    int intDispositivo;
    @Column(name = "CONSUMO_TOTAL_MES_HISTORICO")
    double consumoTotal;
    @Column(name = "MES_ANO_HISTORICO")
    String mesAno;

}
