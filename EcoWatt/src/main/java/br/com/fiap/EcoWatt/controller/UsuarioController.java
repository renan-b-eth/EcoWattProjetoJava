package br.com.fiap.EcoWatt.controller;

import br.com.fiap.EcoWatt.beans.Usuario;
import br.com.fiap.EcoWatt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioService.consultarUsuario(id);
    }

}