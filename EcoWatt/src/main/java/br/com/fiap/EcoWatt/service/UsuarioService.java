package br.com.fiap.EcoWatt.service;

import br.com.fiap.EcoWatt.beans.Usuario;
import br.com.fiap.EcoWatt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    public Usuario consultarUsuario(Long idUsuario) {
        Map<String, Usuario> resultMap = usuarioRepository.executarConsultaUsuario(idUsuario);
        String nomeUsuario = String.valueOf(resultMap.get("nome_usuario"));
        String emailUsuario = String.valueOf(resultMap.get("email_usuario"));

        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setEmail(emailUsuario);

        return usuario;
    }


}