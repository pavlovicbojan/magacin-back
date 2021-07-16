package com.ftninformatika.jwd.test.Developing.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.test.Developing.model.Artikal;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Long>{
	
	Page<Artikal> findAll(Pageable pageable);
	
	Page<Artikal> findByNazivIgnoreCaseContainsAndMagacinId(String naziv,Pageable pageable, Long MagacinId);
	
	Page<Artikal> findByNazivIgnoreCaseContains(String naziv,Pageable pageable);
	
	Artikal findOneById(Long id);
	
	List<Artikal> findAllByMagacinId(Long magacinId);

}
