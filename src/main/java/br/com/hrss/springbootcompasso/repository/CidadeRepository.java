package br.com.hrss.springbootcompasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hrss.springbootcompasso.data.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query("SELECT c FROM Cidade c WHERE c.nomeCidade =:nomeCidade")
	Cidade findCityByName(@Param("nomeCidade") String nomeCidade);
	
	@Query("SELECT c FROM Cidade c WHERE c.estado =:estado")
	Cidade findCityByState(@Param("estado") String estado);

}
