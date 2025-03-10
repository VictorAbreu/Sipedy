package br.com.vitt.sipedy.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * "
										+ "FROM tb_agendamento  "
										+ "WHERE data LIKE %?1% and userId = ?2")
	Page<Agendamento> findAllPaged(String data, Long idUser, Pageable pageable);
	
}
	