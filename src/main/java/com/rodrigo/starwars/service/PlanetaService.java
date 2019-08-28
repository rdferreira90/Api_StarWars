package com.rodrigo.starwars.service;
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
import org.springframework.web.client.RestTemplate;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;

	public List<Planeta> encontraTodos(){	
		return repo.findAll();
	}

	public Planeta buscarPorNome(String nome){			
		return repo.findByNome(nome);
	}


	public List<Planeta> buscar() {
		List<Planeta> planetas = repo.findAll();
		return planetas;
	}

	public Planeta inserirPlaneta(@RequestBody Planeta planeta){
		return repo.save(planeta);

	}


	public Planeta encontraPorId(String id)  {
		return repo.findById(id).get();
		
	}

	public ResponseEntity<Planeta> deleta(@PathVariable("id") String id) {
		Optional<Planeta> planetaEncontrado = repo.findById(id);
		if(planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		repo.deleteById(id);

		return new ResponseEntity<Planeta>(HttpStatus.OK);
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
