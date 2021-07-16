package com.ftninformatika.jwd.test.Developing.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.web.dto.ArtikalDTO;

@Component
public class ArtikalToArtikalDTO implements Converter<Artikal, ArtikalDTO>{
	
	@Autowired
	private MagacinToMagacinDTO toMagacinDTO;
	
	@Override
	public ArtikalDTO convert(Artikal source) {
		ArtikalDTO dto = new ArtikalDTO();
		dto.setId(source.getId());
		dto.setJedinicaMere(source.getJedinicaMere());
		dto.setKalkulisanaCena(source.getKalkulisanaCena());
		dto.setKolicina(source.getKolicina());
		dto.setNaziv(source.getNaziv());
		dto.setPakovanje(source.getPakovanje());
		dto.setMagacinDTO(toMagacinDTO.convert(source.getMagacin()));
		
		return dto;
	}
	
	public List<ArtikalDTO> convert(List<Artikal> lista){
		List<ArtikalDTO> dtos = new ArrayList<ArtikalDTO>();
		
		for (Artikal a : lista) {
			dtos.add(convert(a));
		}
		
		return dtos;
	}
	
}
