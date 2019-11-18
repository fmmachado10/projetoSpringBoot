package com.projetoSpringBoot.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.dto.MotoDto;
import com.projetoSpringBoot.modelo.Moto;
import com.projetoSpringBoot.repository.MotoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/locadora")
@Api(value = "API REST LOCADORA")
@CrossOrigin(origins = "*")
public class LocadoraController {
	
	
	@Autowired
	private LocadoraRepository locadoraRepository;

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
	
	
	
	

}
