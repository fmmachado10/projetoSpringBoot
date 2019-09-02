package com.projetoSpringBoot.modelo;

public class Calculadora {
	
	private char operacao;
	
	private float valor1;
	
	private float valor2;
	
	private float resultado;

	public char getOperacao() {
		return operacao;
	}

	public void setOperacao(char operacao) {
		this.operacao = operacao;
	}

	public float getValor1() {
		return valor1;
	}

	public void setValor1(float valor1) {
		this.valor1 = valor1;
	}

	public float getValor2() {
		return valor2;
	}

	public void setValor2(float valor2) {
		this.valor2 = valor2;
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	
}
