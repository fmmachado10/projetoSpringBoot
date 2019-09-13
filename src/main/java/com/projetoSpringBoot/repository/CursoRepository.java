package com.projetoSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringBoot.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>  {

	List<Curso> findByNome(String nomeCurso);
	
	
}
