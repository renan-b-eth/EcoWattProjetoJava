package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "ECOWATT_LEITURA_CONSUMO")
public class Leitura {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LEITURA")
    int idLeitura;

    @NotEmpty
    @Size(min = 1)
    @Column(name = "CORRENTE_LEITURA")
    double correnteLeitura;

    @Size(min = 1)
    @Column(name = "TENSAO_LEITURA")
    double tensaoLeitura;

    @Size(min = 1)
    @Column(name = "POTENCIA_LEITURA")
    double potencialLeitura;

    @Size(min = 5)
    @Column(name = "DATA_HORA")
    String dataLeitura;

    @Size(min = 1)
    @Column(name = "ID_DISPOSITIVO")
    int idDispositivo;
}
