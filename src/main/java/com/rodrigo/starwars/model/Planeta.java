package com.rodrigo.starwars.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PLANETA")
@Entity
public class Planeta {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private String id;
	
	@Column
	private String nome;
	
	@Column
	private String clima;
	
	@Column
	private String terreno;

	public void setFilms(List<String> films) {
		this.films = films;
	}

	@Transient
	List<String> films;
	
		
	public Planeta(String terreno, String clima, String nome) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Planeta() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	Planeta[] results;
	
	public Planeta[] getResults() {
		return results;
	}
	
	public void setResults(Planeta[] results) {
		this.results = results;
	}

	
	

	public List<String> getFilms() {
		return films;
	}

	public void setFilmes(List<String> films) {
		this.films = films;
	}
}
	
	