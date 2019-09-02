package com.projetoSpringBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusResources {
	
	@GetMapping
	public String hello() {
		return "Olá Fabrício status resource...";
	}
	
	@GetMapping("/ok")
	public ResponseEntity<?> ok() {
		return ResponseEntity.ok("sucesso...");
	}
	
	@GetMapping("invalido")
	public ResponseEntity<?> invalido() {
		return ResponseEntity.badRequest().build();
	}

}
