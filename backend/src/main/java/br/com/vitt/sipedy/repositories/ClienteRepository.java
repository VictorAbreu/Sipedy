package br.com.vitt.sipedy.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT DISTINCT obj FROM Cliente obj WHERE "
			+ "(LOWER(obj.nomeRazao) LIKE LOWER(CONCAT('%',:name,'%')) )")
	Page<Cliente> find(String name, Pageable pageable);

}
	