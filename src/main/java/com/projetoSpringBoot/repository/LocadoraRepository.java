package com.projetoSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringBoot.controlador.Locadora;
import com.projetoSpringBoot.modelo.Moto;

public interface LocadoraRepository extends JpaRepository<Locadora, Long> {
	
	List<Moto> findByModelo(String modelo);

	void deleteById(Long id);

}
