package com.projetoSpringBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringBoot.modelo.Calculadora;

@RestController
@RequestMapping("/testeweb")
public class TesteWeb {
	
	@GetMapping
	public String hello() {
		return "Olá Fabrício...";
	}
	
	@GetMapping("/mens")
	public String hello2() {
		return "Olá Fabrício2222...";
	}
	
	@GetMapping("/retorna/{num}")
	public ResponseEntity<?> retornaNumeros(@PathVariable Long num) {
		String sequencia = "";
		
		for (int i =1; i <= num; i++) {
			sequencia = sequencia + " " + i;
		}
		
		
		return ResponseEntity.ok(sequencia);
		
	}
	
	@PostMapping
	public ResponseEntity<Calculadora> calcular(@RequestBody Calculadora calculadora) {
		
		char operacao = calculadora.getOperacao();
		//xxxfabricio
		
		switch (calculadora.getOperacao()) {
		case '+':		
			System.out.println("Soma");				
			calculadora.setResultado(calculadora.getValor1() + calculadora.getValor2());
			break;
	
		case '-':
			System.out.println("Subtração");
			calculadora.setResultado(calculadora.getValor1() - calculadora.getValor2());
			break;
			
		case '*':
			calculadora.setResultado(calculadora.getValor1() * calculadora.getValor2());
			System.out.println("Multiplicação");
			break;
			
		case '/':
			calculadora.setResultado(calculadora.getValor1() / calculadora.getValor2());
			System.out.println("Divisão");
			break;
			
		default:
			calculadora.setResultado(0);
			return ResponseEntity.status(400).body(calculadora);
			
		}
				
		return ResponseEntity.status(201).body(calculadora);
		
	}
	

}
