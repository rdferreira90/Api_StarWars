package com.rodrigo.starwars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo.starwars.model.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, String> {

	@Query("select p from Planeta p where p.nome=:nome")
	public Planeta findByNome(String nome);

		
//	@Query("select p from Planeta p where p.id=:id")
//	public Planeta findById(String id);
}
