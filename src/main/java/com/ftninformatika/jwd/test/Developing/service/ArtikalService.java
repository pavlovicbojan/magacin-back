package com.ftninformatika.jwd.test.Developing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.test.Developing.model.Artikal;

public interface ArtikalService {

	Page<Artikal> getAllSearch(String naziv,int pageNo, Long magacinId);
	
	Artikal findOneById(Long id);
	
	Artikal save(Artikal artikal);
	
	Artikal update(Artikal artikal);
	
	void delete(Long id);
	
	List<Artikal> findByMagacinId(Long id);
}
