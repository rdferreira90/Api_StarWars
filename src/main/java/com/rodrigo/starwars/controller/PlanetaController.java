package com.rodrigo.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.service.PlanetaService;

@RestController
@RequestMapping("/api")
public class PlanetaController {
	
	
	@Autowired
	private PlanetaService service;
	
	
	@GetMapping(path = "/planeta")
	public ResponseEntity<List<Planeta>> encontraTodos() {
		List<Planeta> planets = service.buscar();
		
		for(int i = 0; i < planets.size(); i++) {
			int vezes = service.retornaQuantidadeFilms(planets.get(i).getNome());
			planets.get(i).setQuantidadeAparicoes(vezes);
		}
				
		return new ResponseEntity<>(planets, HttpStatus.OK);
	}
	
	@GetMapping(path = "/planeta/{id}")
	public ResponseEntity<Planeta> encontraPorId(@PathVariable("id") String id) {
			Planeta planet = service.encontraPorId(id);
			planet.setQuantidadeAparicoes(service.retornaQuantidadeFilms(planet.getNome()));
			return new ResponseEntity<>(planet, HttpStatus.OK);
	}
	
	@PostMapping(path = "/planeta")
	public Planeta inserirPlaneta(@RequestBody Planeta planeta){
		return service.inserirPlaneta(planeta);
		
	}
	
	@PutMapping(path = "/planeta")
	public Planeta atualizaPlaneta(@RequestBody Planeta planeta){
		return service.atualizaPlaneta(planeta);
	}
	
	@DeleteMapping(path ={"planeta/{id}"})
	public ResponseEntity<Planeta> deleta(@PathVariable("id") String id){
		return service.deleta(id);
				
	}
		
	@GetMapping(path="/planeta/search/{nome}")
	public ResponseEntity<Planeta> searchPlanet(@PathVariable("nome") String nome) {
		Planeta planeta = service.buscarPorNome(nome);
		planeta.setQuantidadeAparicoes(service.retornaQuantidadeFilms(nome));
		
		return new ResponseEntity<>(planeta, HttpStatus.OK);
	}
}
	

	