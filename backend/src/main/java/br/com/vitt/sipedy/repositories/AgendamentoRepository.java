package br.com.vitt.sipedy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
}
	