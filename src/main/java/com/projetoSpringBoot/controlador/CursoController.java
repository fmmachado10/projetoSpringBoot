package com.projetoSpringBoot.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.dto.CursoDto;
import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.repository.CursoRepository;

@RestController
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping("/cursos")	
	public List<CursoDto> lista(String nome) {
		
		if (nome == null) {
			List<Curso> cursos = cursoRepository.findAll();
			return CursoDto.converter(cursos);
		} else {
			List<Curso> cursos = cursoRepository.findByNome(nome);
			return CursoDto.converter(cursos);
		}
		
	}
	

}
