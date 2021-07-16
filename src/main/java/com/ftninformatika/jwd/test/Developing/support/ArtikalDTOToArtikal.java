package com.ftninformatika.jwd.test.Developing.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.repository.StavkePrijemRepository;
import com.ftninformatika.jwd.test.Developing.service.MagacinService;
import com.ftninformatika.jwd.test.Developing.service.StavkaPrijemaService;
import com.ftninformatika.jwd.test.Developing.web.dto.ArtikalDTO;

@Component
public class ArtikalDTOToArtikal implements Converter<ArtikalDTO, Artikal>{
	
	@Autowired
	private MagacinService magacinService;
	
	@Autowired
	private StavkaPrijemaService stavkaPrijemaService;
	
	
	@Override
	public Artikal convert(ArtikalDTO source) {
		Artikal a = new Artikal();
		a.setId(source.getId());
		a.setJedinicaMere(source.getJedinicaMere());
		a.setKalkulisanaCena(source.getKalkulisanaCena());
		a.setKolicina(source.getKolicina());
		a.setNaziv(source.getNaziv());
		a.setMagacin(magacinService.findById(source.getMagacinDTO().getId()));
		a.setPakovanje(source.getPakovanje());
		a.setStavkePrijema(stavkaPrijemaService.findByArtikal(source.getId()));
		return a;
	}
	

}
