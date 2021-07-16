package com.ftninformatika.jwd.test.Developing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;
import com.ftninformatika.jwd.test.Developing.repository.StavkePrijemRepository;
import com.ftninformatika.jwd.test.Developing.service.ArtikalService;
import com.ftninformatika.jwd.test.Developing.service.StavkaPrijemaService;
import com.ftninformatika.jwd.test.Developing.support.StavkaPrijemaDTOToStavkaPrijema;
import com.ftninformatika.jwd.test.Developing.web.dto.StavkaPrijemaDTO;

@Service
public class JpaStavkaPrijemService implements StavkaPrijemaService{
	
	@Autowired
	private StavkePrijemRepository stavkaPrijemaRepository;
	
	@Autowired
	private StavkaPrijemaDTOToStavkaPrijema toPrijem;
	
	@Autowired
	private ArtikalService artikalService;
	
	@Override
	public List<StavkaPrijema> findByArtikal(Long id) {
		return stavkaPrijemaRepository.findAllByArtikalId(id);
	}

	@Override
	public StavkaPrijema save(StavkaPrijemaDTO stavkaPrijemDTO) {
		Artikal artikal = artikalService.findOneById(stavkaPrijemDTO.getArtikalDTO().getId());
		Integer kolicina = artikal.getKolicina() +  stavkaPrijemDTO.getKolicina();
		
		Double kalkulisanaCena = (artikal.getKolicina() * artikal.getKalkulisanaCena() +
				stavkaPrijemDTO.getKolicina() * stavkaPrijemDTO.getJedinicnaCena()) / kolicina ;
		artikal.setKalkulisanaCena(kalkulisanaCena);
		artikal.setKolicina(kolicina);
		StavkaPrijema stavkaPrijema = toPrijem.convert(stavkaPrijemDTO);
		
		return stavkaPrijemaRepository.save(stavkaPrijema);
		
	}

	@Override
	public StavkaPrijema findOneById(Long id) {
		return stavkaPrijemaRepository.findOneById(id);
	}

}
