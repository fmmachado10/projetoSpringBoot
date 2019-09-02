package com.projetoSpringBoot.resources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetoSpringBoot.modelo.Fornecedor;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResources {
	
	@GetMapping
	public String hello() {
		return "Olá Fabrício...";
	}
	
	@GetMapping("/consulta")
	public List<Fornecedor> getFornecedores() {
		
		List<Fornecedor> listaFornecedor = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++ ) {
			
			Fornecedor f = new Fornecedor();
			
			f.setId(i);
			f.setNome("Nome" + i);
			f.setCnpj("Cnpj" + i);
			
			listaFornecedor.add(f);
			
		}
				
		return listaFornecedor;
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> cadastrar(@RequestBody Fornecedor fornecedor) throws IOException {
				
		try {
			
			//CONVERTE O OBJETO EM JSON
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(fornecedor));
			
			String jsonFornecedor = mapper.writeValueAsString(fornecedor);
			
			//GRAVA O ARQUIVO JSON
			FileWriter writeFile = null;
			writeFile = new FileWriter("saida.json");
            //ESCREVE NO ARQUIVO O CONTEUDO O OBJETO JSON
            writeFile.write(jsonFornecedor);
            writeFile.close();
			
			
		} catch (JsonProcessingException e) {
						
			e.printStackTrace();
			
		}
				
		return ResponseEntity.status(201).body(fornecedor);
		
	}
	
}
