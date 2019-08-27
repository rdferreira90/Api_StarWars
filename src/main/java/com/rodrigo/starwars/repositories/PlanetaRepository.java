package com.rodrigo.starwars.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.starwars.model.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, String> {

	public List<Planeta> findByNome(String nome);
	
}
