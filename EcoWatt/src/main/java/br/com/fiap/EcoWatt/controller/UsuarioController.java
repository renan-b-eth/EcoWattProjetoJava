package br.com.fiap.EcoWatt.controller;

import br.com.fiap.EcoWatt.beans.Usuario;
import br.com.fiap.EcoWatt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        usuarioService.inserirUsuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.ok("Usuário criado com sucesso");
    }
}