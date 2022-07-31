package br.com.vitt.sipedy.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query("SELECT DISTINCT obj FROM Empresa obj WHERE "
			+ "(LOWER(obj.nomeRazao) LIKE LOWER(CONCAT('%',:name,'%')) )")
	Page<Empresa> find(String name, Pageable pageable);

}
	