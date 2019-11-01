package com.projetoSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.modelo.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {

	
	List<Moto> findByNome(String modelo);

	void deleteById(Long id);
	
}
