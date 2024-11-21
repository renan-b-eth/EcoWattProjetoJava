package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "ECOWATT_HISTORICO_MENSAL")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    int idHistorico;
    @Column(name = "ID_DISPOSITIVO")
    int intDispositivo;
    @Column(name = "CONSUMO_TOTAL_MES_HISTORICO")
    double consumoTotal;
    @Column(name = "MES_ANO_HISTORICO")
    String mesAno;

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIntDispositivo() {
        return intDispositivo;
    }

    public void setIntDispositivo(int intDispositivo) {
        this.intDispositivo = intDispositivo;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }
}
