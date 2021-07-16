package com.ftninformatika.jwd.test.Developing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.Developing.model.Artikal;
import com.ftninformatika.jwd.test.Developing.model.Magacin;
import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;
import com.ftninformatika.jwd.test.Developing.repository.ArtikalRepository;
import com.ftninformatika.jwd.test.Developing.repository.MagacinRepository;
import com.ftninformatika.jwd.test.Developing.repository.StavkePrijemRepository;
import com.ftninformatika.jwd.test.Developing.service.ArtikalService;

@Service
public class JpaArtikalService implements ArtikalService {

	@Autowired
	private ArtikalRepository artikalRepository;
	
	@Autowired
	private MagacinRepository magacinRepository;
	
	@Autowired
	private StavkePrijemRepository prijemRepository;

	@Override
	public Page<Artikal> getAllSearch(String naziv, int pageNo, Long magacinId) {
		if (magacinId == 0) {
			return artikalRepository.findByNazivIgnoreCaseContains(naziv, PageRequest.of(pageNo, 2));
		}
		return artikalRepository.findByNazivIgnoreCaseContainsAndMagacinId(naziv, PageRequest.of(pageNo, 2), magacinId);
	}

	@Override
	public Artikal findOneById(Long id) {
		return artikalRepository.findOneById(id);
	}

	@Override
	public Artikal save(Artikal artikal) {
		if(artikal.getKolicina() == null && artikal.getKalkulisanaCena() == null) {
			artikal.setKalkulisanaCena(0.0);
			artikal.setKolicina(0);
		}
		
		Artikal sacuvaniArtikal = artikalRepository.save(artikal);
		return sacuvaniArtikal;
	}

	@Override
	public Artikal update(Artikal artikal) {
		
		return artikalRepository.save(artikal);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Artikal artikal = artikalRepository.findOneById(id);
		Magacin magacin = magacinRepository.findOneById(artikal.getMagacin().getId());
		magacin.getListaArtikala().remove(artikal);
		prijemRepository.deleteByArtikalId(id);
		artikalRepository.deleteById(id);
		
	}

	@Override
	public List<Artikal> findByMagacinId(Long id) {
		List<Artikal> artikli = artikalRepository.findAllByMagacinId(id);
		
		return artikli;
	
	}

}
