package com.ftninformatika.jwd.test.Developing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StavkaPrijema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Integer kolicina;
	@Column
	private Double jedinicnaCena;
	@ManyToOne
	private Artikal artikal;
	
	public StavkaPrijema() {
		super();
	}

	public StavkaPrijema(Long id, Integer kolicina, Double jedinicnaCena, Artikal artikal) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.jedinicnaCena = jedinicnaCena;
		this.artikal = artikal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(Double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}
	
	
	
	
	
}
