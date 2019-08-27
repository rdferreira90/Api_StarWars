package com.rodrigo.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.service.PlanetaService;

@RestController
@RequestMapping("/api")
public class PlanetaController {
	
	
	@Autowired
	private PlanetaService service;
	
	
	@GetMapping(path = "/planeta")
	public ResponseEntity<Object> encontraTodos(@RequestParam (value = "nome", required = false) String nome){
		return service.encontraTodos(nome);
	}
	
	@GetMapping(path = "/planeta/{id}")
	public Planeta encontraPorId(@PathVariable String id) throws Exception{
			return service.encontraPorId(id);
	}
	
	@PostMapping(path = "/planeta")
	public Planeta inserirPlaneta(@RequestBody Planeta planeta){
		return service.inserirPlaneta(planeta);
		
	}
	
	@DeleteMapping(path ={"planeta/{id}"})
	public ResponseEntity<Planeta> deleta(@PathVariable("id") String id){
		return service.deleta(id);
				
	}
		
	@GetMapping(path="/planeta/search/{nome}")
	public ResponseEntity<Integer> searchPlanet(@PathVariable("nome") String nome) {
		
		return ResponseEntity.ok(service.retornaQuantidadeFilms(nome));
		
	}
	

}
	

	