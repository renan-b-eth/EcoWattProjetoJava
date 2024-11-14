package br.com.fiap.EcoWatt.service;

import br.com.fiap.EcoWatt.beans.Usuario;
import br.com.fiap.EcoWatt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UsuarioRepository
    usuarioRepository;

    public void inserirUsuario(String nome, String email, String senha) {
        jdbcTemplate.update("CALL Inserir_Usuario(?, ?, ?)", nome, email, senha);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}