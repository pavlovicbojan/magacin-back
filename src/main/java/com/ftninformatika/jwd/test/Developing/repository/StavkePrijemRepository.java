package com.ftninformatika.jwd.test.Developing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.test.Developing.model.StavkaPrijema;

@Repository
public interface StavkePrijemRepository extends JpaRepository<StavkaPrijema, Long>{
	
	List<StavkaPrijema> findAllByArtikalId(Long artikal);
	
	StavkaPrijema findOneById(Long id);
	
	void deleteByArtikalId(Long id);
}
