package com.rodrigo.starwars.controller;






import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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
	@Autowired
	private PlanetaService service;
	
//	@GetMapping(path = "/planeta")
//	public Planeta findAll() {
//		Planeta obj = (Planeta) repo.findAll();
//		return obj;
//	}
	
	
	
	
	@GetMapping(path = "/planeta")
	public ResponseEntity<Object> encontraTodos(){
		List<Planeta> planeta = new ArrayList<Planeta>();
		planeta = repo.findAll();
		return ResponseEntity.ok(planeta);
	}
}

