package com.projetoSpringBoot.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoSpringBoot.modelo.Topico;

@Controller
public class TopicosController {

	@RequestMapping("/topicos")	
	public List<Topico> lista() {
		
		return null;
	}
	
}
