package br.com.fiap.EcoWatt.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    int idUsuario;

    @Size(min = 3, max = 50)
    @Column(name = "NOME_USUARIO")
    String nome;

    @Email
    @Column(name = "EMAIL_USUARIO")
    String email;

    @Size(min = 5, max = 50)
    @Column(name = "SENHA_USUARIO")
    String senha;
}
