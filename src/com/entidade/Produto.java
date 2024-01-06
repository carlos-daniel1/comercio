package com.entidade;

public class Produto {
	private String nome;
	private String codigo;
	private int estoque;
	
	public Produto(String nome, String codigo, int estoque) {
		setNome(nome);
		setCodigo(codigo);
		setEstoque(estoque);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
