package com.projetoSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringBoot.modelo.Moto;
import com.projetoSpringBoot.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	List<Veiculo> findByVeiculo(String veiculo);

	void deleteById(Long id);

}
