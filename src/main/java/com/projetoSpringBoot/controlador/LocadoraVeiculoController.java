package com.projetoSpringBoot.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.dto.VeiculoDto;
import com.projetoSpringBoot.modelo.Veiculo;
import com.projetoSpringBoot.repository.VeiculoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/locadoraVeiculo")
@Api(value = "API REST LOCADORA")
@CrossOrigin(origins = "*")
public class LocadoraVeiculoController {
	
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista veículos.")
	public List<VeiculoDto> lista(String veiculo) {

		if (veiculo == null) {
			List<Veiculo> veiculos = veiculoRepository.findAll();
			//return VeiculoDto.converteParaDto(veiculos);
			return null;
		} else {
			List<Veiculo> veiculos = veiculoRepository.findByVeiculo(veiculo);
			//return VeiculoDto.converteParaDto(veiculos);
			return null;
		}

	}
	
	
	
	

}
