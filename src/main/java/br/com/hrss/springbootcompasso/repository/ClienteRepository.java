package br.com.hrss.springbootcompasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hrss.springbootcompasso.data.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT cli FROM Cliente cli WHERE cli.nomeCompleto =:nomeCompleto")
	Cliente findClientByName(@Param("nomeCompleto") String nomeCompleto);
}
