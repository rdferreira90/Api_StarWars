package com.rodrigo.starwars.service;

import java.util.List;

import com.rodrigo.starwars.model.Planeta;

public class PlanetaService {

	
	public List<PlanetaService> getNomePlaneta() {
		return PlanetaService.findAllActive();
}

	private static List<PlanetaService> findAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object incluir(Planeta planeta) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object alterar(Planeta planeta) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
