package com.projetoSpringBoot.controlador;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.dto.CursoDto;
import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.repository.CursoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cursos")
@Api(value = "API REST CURSOS")
@CrossOrigin(origins = "*")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de cursos.")
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
	@ApiOperation(value = "Cadastra um curso.")
	public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid  CursoDto cursoDto) throws IOException {

		Curso curso = cursoDto.converteParaCurso(cursoDto);

		cursoRepository.save(curso);
		
		return ResponseEntity.status(201).body(new CursoDto(curso));

	}
	
	
	@DeleteMapping("/{id}")	
	@ApiOperation(value = "Cadastra um curso pelo id.")
	public ResponseEntity<Long> delete(@PathVariable Long id) {
		
		cursoRepository.deleteById(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um curso.")
	public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso c) {
	/*
		Curso curso = cursoRepository.findById(id);
		
		BeanUtils.copyProperties(c, curso, "id");
		
		cursoRepository.save(curso);
		
		return ResponseEntity.ok(curso);
	*/
		
		return null;
	}
	
	

}
