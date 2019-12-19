package com.projetoSpringBoot.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.projetoSpringBoot.modelo.Curso;
import com.projetoSpringBoot.modelo.Moto;

public class MotoDto {

	private Long id;

	@NotNull
	@NotEmpty(message = "O campo nome deve ser preenchido.")
	@Length(min = 5, max = 50, message = "Campo modelo deve ter entre 5 e 30 caracteres.")
	private String modelo;

	private String ano;

	private String cor;

	public MotoDto() {

	}

	public MotoDto(Moto moto) {

		this.id = moto.getId();

		this.modelo = moto.getModelo();

		this.ano = moto.getAno();

		this.cor = moto.getCor();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static List<MotoDto> converteParaDto(List<Moto> motos) {

		return motos.stream().map(MotoDto::new).collect(Collectors.toList());

	}

	public Moto converteParaMoto(MotoDto motoDto) {
		return new Moto(modelo, ano, cor);
	}

}
