package com.rodrigo.starwars.client;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rodrigo.starwars.model.Planeta;
import com.rodrigo.starwars.service.ServiceUnavailable;

public class StarWarsApiRest extends Planeta{
	
	
		RestTemplate restTemplate = new RestTemplate();
		
		public ResponseEntity<Planeta> retornaAparicoes() throws ServiceUnavailable {
	
		try {
			return restTemplate.exchange("https://swapi.co/api/planets/?search=" + getNome() , HttpMethod.GET, geraHeader(), Planeta.class);
		
		}catch(Exception e) {
	   			throw new ServiceUnavailable("SWAPI fora do ar");
	   		}
		
			
	}
		private HttpEntity<String> geraHeader() {
			HttpHeaders headers = new HttpHeaders();
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			
			return entity;
		}
}

