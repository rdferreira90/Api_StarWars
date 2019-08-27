package com.rodrigo.starwars.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	
	public ResponseEntity<Object> encontraTodos(@RequestParam (value = "nome", required = false) String nome){
		List<Planeta> planeta = new ArrayList<Planeta>();
		
		if(nome == null) {
			planeta = repo.findAll();
			
		} else {
			planeta = repo.findByNome(nome);
		}
			return ResponseEntity.ok(planeta);
	}
	
	
	public Planeta buscar() {
		Planeta obj = (Planeta) repo.findAll();
		return obj;
	}
	
	public Planeta inserirPlaneta(@RequestBody Planeta planeta){
		return repo.save(planeta);
		
	}

	
	public Planeta encontraPorId(String id) throws Exception {
		Optional<Planeta> planeta = repo.findById(id);
		if(!planeta.isPresent())
			throw new Exception("id-" + id);
			
		return planeta.get();
	}

	public ResponseEntity<Planeta> deleta(@PathVariable("id") String id) {
		Optional<Planeta> planetaEncontrado = repo.findById(id);
		if(planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		repo.deleteById(id);
		
		return new ResponseEntity<Planeta>(HttpStatus.OK);
	}
	
	public List<Planeta> searchPlanet(@PathVariable("nome") String nome) {
		List<Planeta> planeta = repo.findByNome(nome);
		return planeta;
		
	}
	
	public Integer retornaQuantidadeFilms(String nome) {
		
		RestTemplate restTemplate = new RestTemplate();
				
			Planeta planeta =  restTemplate.exchange("https://swapi.co/api/planets/?search=" + nome , HttpMethod.GET, geraHeader(), Planeta.class).getBody();
			return planeta.getResults()[0].getFilms().size();
						
	}
	
	private HttpEntity<String> geraHeader() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return entity;
	}
	
	
	
	
}
