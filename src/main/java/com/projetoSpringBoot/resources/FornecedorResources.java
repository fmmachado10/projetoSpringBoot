package com.projetoSpringBoot.resources;

import java.io.BufferedReader;
import java.io.FileReader;
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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.projetoSpringBoot.modelo.Fornecedor;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResources {
	
	@GetMapping
	public String hello() {
		return "Olá Fabrício...";
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
			writeFile = new FileWriter("saida.json", true);
            //ESCREVE NO ARQUIVO O CONTEUDO O OBJETO JSON
            writeFile.write(jsonFornecedor + "\r\n");
            writeFile.close();
			
			
		} catch (JsonProcessingException e) {
						
			e.printStackTrace();
			
		}
				
		return ResponseEntity.status(201).body(fornecedor);
		
	}
	
	@GetMapping("/consulta")
	public List<Fornecedor> consulta() {
		
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		
		try {
		
		//Lê O ARQUIVO
        FileReader ler = new FileReader("saida.json");
        BufferedReader reader = new BufferedReader(ler);  
        String linha;
        
        while( (linha = reader.readLine()) != null ){
            
        	System.out.println(linha);
        	Gson gson = new Gson();			
			Fornecedor fornecedor = gson.fromJson(linha, Fornecedor.class);
			listaFornecedor.add(fornecedor);
            
        }
        		
	} catch (JsonSyntaxException | IOException e) {
		
		e.printStackTrace();
		
	}
				
		return listaFornecedor;
		
	}
	
}
