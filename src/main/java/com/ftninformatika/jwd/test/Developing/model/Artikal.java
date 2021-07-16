package com.ftninformatika.jwd.test.Developing.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artikal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private Double pakovanje;
	@Column
	private String jedinicaMere;
	@Column
	private Integer kolicina;
	@Column
	private Double kalkulisanaCena;
	@ManyToOne
	private Magacin magacin;
	@OneToMany(mappedBy = "artikal")
	private List<StavkaPrijema> stavkePrijema;
	
	public Artikal() {
		super();
	}

	public Artikal(Long id, String naziv, Double pakovanje, String jedinicaMere, Integer kolicina,
			Double kalkulisanaCena, Magacin magacin, List<StavkaPrijema> stavkePrijema) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pakovanje = pakovanje;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.kalkulisanaCena = kalkulisanaCena;
		this.magacin = magacin;
		this.stavkePrijema = stavkePrijema;
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

	public Double getPakovanje() {
		return pakovanje;
	}

	public void setPakovanje(Double pakovanje) {
		this.pakovanje = pakovanje;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Double getKalkulisanaCena() {
		return kalkulisanaCena;
	}

	public void setKalkulisanaCena(Double kalkulisanaCena) {
		this.kalkulisanaCena = kalkulisanaCena;
	}

	public Magacin getMagacin() {
		return magacin;
	}

	public void setMagacin(Magacin magacin) {
		this.magacin = magacin;
	}

	public List<StavkaPrijema> getStavkePrijema() {
		return stavkePrijema;
	}

	public void setStavkePrijema(List<StavkaPrijema> stavkePrijema) {
		this.stavkePrijema = stavkePrijema;
	}
	
	
	
}
