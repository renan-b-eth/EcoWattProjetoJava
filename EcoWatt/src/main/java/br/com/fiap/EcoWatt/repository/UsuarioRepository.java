package br.com.fiap.EcoWatt.repository;

import br.com.fiap.EcoWatt.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ECOWATT_USUARIO WHERE ID_USUARIO = :id_usuario")
    Usuario executarConsultaUsuario(@Param("id_usuario") Long idUsuario);

    /*Usuario consultarUsuario(@Param("id_usuario") Long idUsuario);*/
}
