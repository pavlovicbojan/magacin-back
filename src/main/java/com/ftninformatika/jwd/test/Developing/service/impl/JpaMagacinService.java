package com.ftninformatika.jwd.test.Developing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.Developing.model.Magacin;
import com.ftninformatika.jwd.test.Developing.repository.MagacinRepository;
import com.ftninformatika.jwd.test.Developing.service.MagacinService;

@Service
public class JpaMagacinService implements MagacinService{

	@Autowired
	private MagacinRepository magacinRepository;
	
	@Override
	public List<Magacin> findAll() {
		return magacinRepository.findAll();
	}

	@Override
	public Magacin findById(Long id) {
		return magacinRepository.findOneById(id);
	}

}
