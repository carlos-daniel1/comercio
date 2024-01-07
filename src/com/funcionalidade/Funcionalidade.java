package com.funcionalidade;

import java.util.ArrayList;
import com.entidade.*;

public class Funcionalidade {

	private static ArrayList<Produto> ListaProdutos = new ArrayList<Produto>();

	public static String printarProdutos() {
		String msg = "";
		if (ListaProdutos.isEmpty()) {
			msg = "Não existem produtos cadastrados";
		} else {
			for (Produto p : ListaProdutos) {
				msg += String.format("%s (cód.: %d | estoque: %d)\n", p.getNome(), p.getCodigo(), p.getEstoque());
			}
		}

		return msg;
	}

	public static boolean tentarInt(String codigo) {
		try {
			Integer.parseInt(codigo);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean verificarCodigo(String codigo) {
		if (!tentarInt(codigo)) {
			return false;
		}
		for (Produto p : ListaProdutos) {
			if (Integer.parseInt(codigo) == p.getCodigo()) {
				return false;
			}
		}

		return true;
	}

	public static String printarAtual(String nome, String codigo, String estoque) {
		return String.format("%s cadastrado com sucesso! (Código: %s | Estoque: %s)\n", nome, codigo, estoque);
	}

	public static String exibirMenu() {
		return """
				1) Listar todos os produtos
				2) Cadastrar novo produto
				3) Adicionar estoque de um produto;
				4) Remover produto
				5) Vender produto
				6) Sair
				\nEscolha uma opção:
				""";
	}

	public static void addProduto(Produto produto) {
		ListaProdutos.add(produto);
	}

}
