package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOWATT_ENDERECO")
public class Endereco {

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Id
    @Column(name = "ID_ENDERECO")
    int idEndereco;
    @Column(name = "RUA_ENDERECO")
    String logradouro;
    @Column(name = "NUMERO_ENDERECO")
    String numero;
    @Column(name = "BAIRRO_ENDERECO")
    String bairro;
    @Column(name = "CIDADE_ENDERECO")
    String cidade;
    @Column(name = "ESTADO_ENDERECO")
    String estado;
    @Column(name = "CEP_ENDERECO")
    String cep;
}
