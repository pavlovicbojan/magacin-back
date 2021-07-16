package com.ftninformatika.jwd.test.Developing.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ArtikalDTO {
	private Long id;
	
	private String naziv;
	@Positive
	private Double pakovanje;
	@NotBlank
	private String jedinicaMere;
	
	private Integer kolicina;
	
	private Double kalkulisanaCena;
	
	private MagacinDTO magacinDTO;
	
	public ArtikalDTO() {
		super();
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

	public MagacinDTO getMagacinDTO() {
		return magacinDTO;
	}

	public void setMagacinDTO(MagacinDTO magacinDTO) {
		this.magacinDTO = magacinDTO;
	}
	
	
	
	
}
