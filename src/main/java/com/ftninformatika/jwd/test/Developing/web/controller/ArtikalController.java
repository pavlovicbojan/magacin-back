package com.ftninformatika.jwd.test.Developing.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.service.ArtikalService;
import com.ftninformatika.jwd.test.Developing.support.ArtikalDTOToArtikal;
import com.ftninformatika.jwd.test.Developing.support.ArtikalToArtikalDTO;
import com.ftninformatika.jwd.test.Developing.web.dto.ArtikalDTO;

@RestController
@RequestMapping(value = "/api/artikli")
public class ArtikalController {

	@Autowired
	private ArtikalService artikalService;

	@Autowired
	private ArtikalToArtikalDTO toArtikalDTO;
	
	@Autowired
	private ArtikalDTOToArtikal toArtikal;

	@GetMapping
	public ResponseEntity<List<ArtikalDTO>> getAllSearch(
			@RequestParam(value = "naziv", required = false, defaultValue = "") String naziv,
			@RequestParam(value = "pageNo" ,required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = "magacinId" ,required = false, defaultValue = "0") Long magacinId) {
		
		Page<Artikal> list = artikalService.getAllSearch(naziv, pageNo, magacinId);
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(list.getTotalPages()));
		
		return new ResponseEntity<>(toArtikalDTO.convert(list.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ArtikalDTO> getById(@PathVariable Long id){
		
		Artikal artikal = artikalService.findOneById(id);
		if (artikal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(toArtikalDTO.convert(artikal), HttpStatus.OK);
		
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ArtikalDTO> create(@Valid @RequestBody ArtikalDTO artikalDTO){
		
		Double kalkulisanaCena = artikalDTO.getKalkulisanaCena();
		Integer kolicina = artikalDTO.getKolicina();
		if (kalkulisanaCena == null && kolicina == null) {
			artikalDTO.setKalkulisanaCena(0.0);
			artikalDTO.setKolicina(0);
		}
		
		Artikal artikal = toArtikal.convert(artikalDTO);
		
		Artikal sacuvaniArtikal = artikalService.save(artikal);
		
		return new ResponseEntity<>(toArtikalDTO.convert(sacuvaniArtikal), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}", consumes = "application/json") 
	public ResponseEntity<ArtikalDTO> update (@PathVariable Long id, @Valid @RequestBody ArtikalDTO artikalDTO){
		 
		if(!id.equals(artikalDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Artikal artikal = toArtikal.convert(artikalDTO);
		Artikal izmenjeniArtikal = artikalService.update(artikal);
		
		return new ResponseEntity<>(toArtikalDTO.convert(izmenjeniArtikal), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<Void> delete (@PathVariable Long id){
		Artikal artikal = artikalService.findOneById(id);

		if (artikal == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}else if(!artikal.getKolicina().equals(0)) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		artikalService.delete(id);
		
		return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
