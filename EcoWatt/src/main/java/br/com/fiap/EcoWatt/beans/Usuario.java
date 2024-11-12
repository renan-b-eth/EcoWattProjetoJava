package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOWATT_USUARIO")
public class Usuario {

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "ID_USUARIO")
    int idUsuario;
    @Column(name = "NOME_USUARIO")
    String nome;
    @Column(name = "EMAIL_USUARIO")
    String email;
    @Column(name = "SENHA_USUARIO")
    String senha;
}
