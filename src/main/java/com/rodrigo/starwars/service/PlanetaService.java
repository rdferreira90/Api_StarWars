package com.rodrigo.starwars.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	
	
	public Planeta buscar() {
		Planeta obj = (Planeta) repo.findAll();
		return obj;
	}

		
}
