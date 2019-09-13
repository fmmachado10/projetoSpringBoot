package com.projetoSpringBoot.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.dto.CursoDto;
import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<CursoDto> lista(String nome) {

		if (nome == null) {
			List<Curso> cursos = cursoRepository.findAll();
			return CursoDto.converteParaDto(cursos);
		} else {
			List<Curso> cursos = cursoRepository.findByNome(nome);
			return CursoDto.converteParaDto(cursos);
		}

	}

	@PostMapping
	public ResponseEntity<Curso> cadastrar(@RequestBody CursoDto cursoDto) throws IOException {

		Curso curso = cursoDto.converteParaCurso(cursoDto);

		cursoRepository.save(curso);

		return ResponseEntity.status(201).body(curso);

	}

}
