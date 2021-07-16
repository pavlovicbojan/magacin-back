package com.ftninformatika.jwd.test.Developing.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.model.Magacin;
import com.ftninformatika.jwd.test.Developing.service.ArtikalService;
import com.ftninformatika.jwd.test.Developing.service.MagacinService;
import com.ftninformatika.jwd.test.Developing.support.ArtikalToArtikalDTO;
import com.ftninformatika.jwd.test.Developing.support.MagacinToMagacinDTO;
import com.ftninformatika.jwd.test.Developing.web.dto.ArtikalDTO;
import com.ftninformatika.jwd.test.Developing.web.dto.MagacinDTO;

@RestController
@RequestMapping(value = "/api/magacin")
public class MagacinController {
	
	@Autowired
	private MagacinService magacinService;
	
	@Autowired
	private ArtikalService artikalService;
	
	@Autowired
	private ArtikalToArtikalDTO toArtikalDTO;
	
	@Autowired 
	private MagacinToMagacinDTO toMagacinDTO;
	
	@GetMapping
	public ResponseEntity<List<MagacinDTO>> getAll (){
		
		List<Magacin> list = magacinService.findAll();
		
		return new ResponseEntity<>(toMagacinDTO.convert(list), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}/artikli") 
	public ResponseEntity<List<ArtikalDTO>> getArtikliByMagacin(@PathVariable Long id){
		
		List<Artikal> artikli = artikalService.findByMagacinId(id);
		
		return new ResponseEntity<>(toArtikalDTO.convert(artikli), HttpStatus.OK);
		
	}
	
	
	

}
