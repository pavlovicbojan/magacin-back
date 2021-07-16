package com.ftninformatika.jwd.test.Developing.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.Developing.model.Magacin;
import com.ftninformatika.jwd.test.Developing.web.dto.MagacinDTO;

@Component
public class MagacinToMagacinDTO implements Converter<Magacin, MagacinDTO> {

	@Override
	public MagacinDTO convert(Magacin source) {
		MagacinDTO dto = new MagacinDTO();
		dto.setId(source.getId());
		dto.setAdresa(source.getAdresa());
		dto.setNaziv(source.getNaziv());
		return dto;
	}
	
	public List<MagacinDTO> convert (List<Magacin> lista){
		List<MagacinDTO> dtos = new ArrayList<MagacinDTO>();
		
		for (Magacin m : lista) {
			dtos.add(convert(m));
			
		}
		
		return dtos;
	}
	
}
