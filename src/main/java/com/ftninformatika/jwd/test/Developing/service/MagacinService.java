package com.ftninformatika.jwd.test.Developing.service;

import java.util.List;

import com.ftninformatika.jwd.test.Developing.model.Magacin;

public interface MagacinService {
	List<Magacin> findAll();
	
	Magacin findById(Long id);
}
