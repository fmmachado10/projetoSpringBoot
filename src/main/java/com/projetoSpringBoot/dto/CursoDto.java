package com.projetoSpringBoot.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projetoSpringBoot.modelo.Curso;

public class CursoDto {
	
	private Long id;
	private String nome;
	private String categoria;
	
	public CursoDto() {
	
	}

	public CursoDto(Curso curso) {
		
		this.id = curso.getId();
		
		this.nome = curso.getNome();
		
		this.categoria = curso.getCategoria();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static List<CursoDto> converteParaDto(List<Curso> cursos) {
		
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
		
	}
	
	public Curso converteParaCurso(CursoDto cursoDto) {
		return new Curso(nome, categoria);
	}


}
