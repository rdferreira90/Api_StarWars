package com.rodrigo.starwars.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="PLANETA")
@Entity
public class Planeta {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column
	private String nome;
	
	@Column
	private String clima;
	
	@Column
	private String terreno;
	
	public Planeta(String terreno, String clima, String nome) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Planeta() {
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
