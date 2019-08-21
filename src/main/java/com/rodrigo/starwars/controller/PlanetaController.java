package com.rodrigo.starwars.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.repositories.PlanetaRepository;
import com.rodrigo.starwars.service.PlanetaService;

@RestController
@RequestMapping("/api")
public class PlanetaController {
	
	@Autowired
	private PlanetaRepository repo;
	
			
	@GetMapping(path = "/planeta")
	public ResponseEntity<Object> encontraTodos(){
		List<Planeta> planeta = new ArrayList<Planeta>();
		planeta = repo.findAll();
		return ResponseEntity.ok(planeta);
	}
	
	@GetMapping(path = {"/planeta/{id}"})
	public Planeta encontraPorId(@PathVariable String id) throws Exception{
			Optional<Planeta> planeta = repo.findById(id);
			if(!planeta.isPresent())
				throw new Exception("id-" + id);
				
			return planeta.get();
	}
	
	@GetMapping(path = {"/planeta/nome"})
	public String encontraPorNome(@PathVariable String nome) throws Exception{
			Planeta planeta = repo.getOne(nome);
			if(!planeta.isPresent())
				throw new Exception("nome-" + nome);
				
			return planeta.getNome();
	}
	
	
}
	

	