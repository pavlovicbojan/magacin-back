package com.ftninformatika.jwd.test.Developing.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;
import com.ftninformatika.jwd.test.Developing.service.ArtikalService;
import com.ftninformatika.jwd.test.Developing.service.StavkaPrijemaService;
import com.ftninformatika.jwd.test.Developing.support.StavkaPrijemaDTOToStavkaPrijema;
import com.ftninformatika.jwd.test.Developing.web.dto.StavkaPrijemaDTO;

@RestController
@RequestMapping(value = "/api/prijem")
public class PrijemController {
	
	@Autowired 
	private StavkaPrijemaService prijemService;
	
//	@Autowired
//	private ArtikalService artikalService;
//	
//	@Autowired
//	private StavkaPrijemaDTOToStavkaPrijema toPrijem;
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody StavkaPrijemaDTO prijemDTO){
		
		StavkaPrijema stavkaPrijema = prijemService.save(prijemDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	

}
