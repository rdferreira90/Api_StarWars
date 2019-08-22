package com.rodrigo.starwars.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.repositories.PlanetaRepository;
import com.rodrigo.starwars.service.PlanetaService;

@RestController
@RequestMapping("/api")
public class PlanetaController {
	
	@Autowired
	private PlanetaRepository repo;
	
	@Autowired
	private PlanetaService service;
			
	@GetMapping(path = "/planeta")
	public ResponseEntity<Object> encontraTodos(@RequestParam (value = "nome", required = false) String nome){
		List<Planeta> planeta = new ArrayList<Planeta>();
		if(nome == null) {
			planeta = repo.findAll();
		} else {
			planeta = repo.findByNome(nome);
		}
			return ResponseEntity.ok(planeta);
	}
	
	@GetMapping(path = "/planeta/{id}")
	public Planeta encontraPorId(@PathVariable String id) throws Exception{
			Optional<Planeta> planeta = repo.findById(id);
			if(!planeta.isPresent())
				throw new Exception("id-" + id);
				
			return planeta.get();
	}
	
	@PostMapping(path = "/planeta")
	public Planeta inserirPlaneta(@RequestBody Planeta planeta){
		return repo.save(planeta);
		
	}
	
	
	
}
	

	