package br.com.fiap.EcoWatt.repository;

import br.com.fiap.EcoWatt.beans.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricoMensalRepository extends JpaRepository<Historico, Long> {

    Optional<Historico> findById(Long id);

}
