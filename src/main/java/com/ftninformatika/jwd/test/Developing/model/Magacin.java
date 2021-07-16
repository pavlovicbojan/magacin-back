package com.ftninformatika.jwd.test.Developing.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Magacin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@OneToMany(mappedBy = "magacin")
	private List<Artikal> listaArtikala;
	
	public Magacin() {
		super();
	}

	public Magacin(Long id, String naziv, String adresa, List<Artikal> listaArtikala) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.listaArtikala = listaArtikala;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}

	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}
	
	
	
}
