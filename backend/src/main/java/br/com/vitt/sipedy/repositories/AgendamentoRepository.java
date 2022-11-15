package br.com.vitt.sipedy.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
	@Query("SELECT DISTINCT obj FROM Agendamento obj WHERE "
			+ "(obj.data LIKE :data)")
	Page<Agendamento> findAllPaged(Date data, Pageable pageable);
	
}
	