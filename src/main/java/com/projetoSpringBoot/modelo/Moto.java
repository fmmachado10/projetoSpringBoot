package com.projetoSpringBoot.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Moto", schema = "public")
public class Moto {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="ano")
	private String ano;
	
	@Column(name="cor")
	private String cor;

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
	
	public Moto(String modelo, String ano, String cor) {
		super();		
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
	}
	
	

}
