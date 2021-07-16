package com.ftninformatika.jwd.test.Developing.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;
import com.ftninformatika.jwd.test.Developing.web.dto.StavkaPrijemaDTO;

@Component
public class StavkaPrijemaDTOToStavkaPrijema implements Converter<StavkaPrijemaDTO, StavkaPrijema>{
	
	@Autowired
	private ArtikalDTOToArtikal toArtikal;
	
	@Override
	public StavkaPrijema convert(StavkaPrijemaDTO source) {
		StavkaPrijema sp = new StavkaPrijema();
		sp.setId(source.getId());
		sp.setJedinicnaCena(source.getJedinicnaCena());
		sp.setKolicina(source.getKolicina());
		sp.setArtikal(toArtikal.convert(source.getArtikalDTO()));
		return sp;
	}


}
