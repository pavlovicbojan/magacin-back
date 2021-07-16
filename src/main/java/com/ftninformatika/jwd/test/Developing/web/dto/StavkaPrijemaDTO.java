package com.ftninformatika.jwd.test.Developing.web.dto;


public class StavkaPrijemaDTO {
	private Long id; 
	private Integer kolicina;
	private Double jedinicnaCena;
	private ArtikalDTO artikalDTO;
	
	public StavkaPrijemaDTO() {
		super();
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

	public ArtikalDTO getArtikalDTO() {
		return artikalDTO;
	}

	public void setArtikalDTO(ArtikalDTO artikalDTO) {
		this.artikalDTO = artikalDTO;
	}

	
	
	
}
