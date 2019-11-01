package com.projetoSpringBoot.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import com.projetoSpringBoot.dto.MotoDto;
import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.modelo.Moto;
import com.projetoSpringBoot.repository.CursoRepository;
import com.projetoSpringBoot.repository.MotoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/motos")
@Api(value = "API REST MOTOS")
@CrossOrigin(origins = "*")
public class MotoController {

	@Autowired
	private MotoRepository motoRepository;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de motos.")
	public List<MotoDto> lista(String modelo) {

		if (modelo == null) {
			List<Moto> motos = motoRepository.findAll();
			return MotoDto.converteParaDto(motos);
		} else {
			List<Moto> motos = motoRepository.findByNome(modelo);
			return MotoDto.converteParaDto(motos);
		}

	}

	@PostMapping
	@ApiOperation(value = "Cadastra uma moto.")
	public ResponseEntity<MotoDto> cadastrar(@RequestBody @Valid MotoDto motoDto) throws IOException {

		Moto moto = motoDto.converteParaMoto(motoDto);

		motoRepository.save(moto);

		return ResponseEntity.status(201).body(new MotoDto(moto));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Cadastra um curso pelo id.")
	public ResponseEntity<Long> delete(@PathVariable Long id) {

		motoRepository.deleteById(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um curso.")
	public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso c) {
		/*
		 * Curso curso = cursoRepository.findById(id);
		 * 
		 * BeanUtils.copyProperties(c, curso, "id");
		 * 
		 * cursoRepository.save(curso);
		 * 
		 * return ResponseEntity.ok(curso);
		 */

		return null;
	}

}
