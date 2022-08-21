package br.com.vitt.sipedy.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vitt.sipedy.entities.Empresa;
import br.com.vitt.sipedy.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.empresas emp WHERE "
			+ "(LOWER(obj.firstName) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<User> find(String name, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.empresas emp WHERE "
			+ "(COALESCE(:empresa) IS NULL OR emp IN :empresa) AND "
			+ "(LOWER(obj.firstName) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<User> pesquisaUsuarioPorEmpresa(List<Empresa> empresa, String name, Pageable pageable);

}
