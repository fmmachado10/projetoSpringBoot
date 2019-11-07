package com.projetoSpringBoot.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projetoSpringBoot.storage.Arquivos;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fotos")
public class FotosUploadController {
	
	@Autowired
	private Arquivos arq;
	
	@PostMapping
	@ApiOperation(value = "Upload de foto.")
	public void upload(@RequestParam MultipartFile foto) {
		
		arq.salvarFoto(foto);
		
	}
	

}
