package com.ftninformatika.jwd.test.Developing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.test.Developing.model.Magacin;

@Repository
public interface MagacinRepository extends JpaRepository<Magacin, Long>{
	Magacin findOneById(Long id);
}
