package com.projetoSpringBoot.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
			List<Moto> motos = motoRepository.findByModelo(modelo);
			return MotoDto.converteParaDto(motos);
		}

	}
	
	@GetMapping("/{id}")
	public MotoDto listaPorId(@PathVariable Long id) {
		
		Moto moto = motoRepository.getOne(id);
		
		return new MotoDto(moto);
		
	}

	@PostMapping
	@ApiOperation(value = "Cadastra uma moto.")
	public ResponseEntity<MotoDto> cadastrar(@RequestBody @Valid MotoDto motoDto) throws IOException {

		Moto moto = motoDto.converteParaMoto(motoDto);

		motoRepository.save(moto);

		return ResponseEntity.status(201).body(new MotoDto(moto));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma moto pelo id.")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		motoRepository.deleteById(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma moto.")
	@Transactional //essa anotação avisa o spring q é p comitar a transação no final do evento.
	public ResponseEntity<MotoDto> update(@PathVariable Long id, @RequestBody Moto m) {
		
		  Moto moto = motoRepository.getOne(id);
		  
		  moto.setAno(m.getAno());
		  
		  moto.setCor(m.getCor());
		  
		  moto.setModelo(m.getModelo());
		  
		  BeanUtils.copyProperties(m, moto, "id");
		  
		  motoRepository.save(moto);
		  
		  return ResponseEntity.status(201).body(new MotoDto(moto));
		
	}

}
