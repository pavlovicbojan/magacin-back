package com.ftninformatika.jwd.test.Developing.service;

import java.util.List;

import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;
import com.ftninformatika.jwd.test.Developing.web.dto.StavkaPrijemaDTO;

public interface StavkaPrijemaService {
	List<StavkaPrijema> findByArtikal(Long id);
	
	StavkaPrijema save(StavkaPrijemaDTO stavkaPrijemDTO);
	
	StavkaPrijema findOneById(Long id);
}
