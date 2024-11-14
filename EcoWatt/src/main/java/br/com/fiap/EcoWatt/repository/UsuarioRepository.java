package br.com.fiap.EcoWatt.repository;

import br.com.fiap.EcoWatt.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}