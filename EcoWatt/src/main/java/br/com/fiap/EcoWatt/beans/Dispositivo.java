package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "ECOWATT_DISPOSITIVO")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISPOSITIVO")
    int idDispositivo;
    @Column(name = "ID_USUARIO")
    int idUsuario;
    @Column(name = "NOME_DISPOSITIVO")
    int nomeDispositivo;

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(int nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }
}
