package com.rodrigo.starwars.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.service.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {
	
	private PlanetaService planetaService;
	
	@GetMapping(path = "/planeta/nome")
	public ResponseEntity<List<PlanetaService>> getNomePlaneta(){
		return ResponseEntity.ok(planetaService.getNomePlaneta());
					
	}
	
	@PostMapping(path="/planeta/clima")
	public ResponseEntity<Object>incluir(@RequestBody Planeta planeta)throws Exception {
		return ResponseEntity.ok(planetaService.incluir(planeta));
	}
	
	@PutMapping(path="/planeta")
	public ResponseEntity<Object>atualizar(@RequestBody Planeta planeta) throws Exception{
		
			return ResponseEntity.ok(planetaService.alterar(planeta));
		
	}
	
	
	
		
}
	
