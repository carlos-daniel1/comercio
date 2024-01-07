package com;

import com.funcionalidade.*;
import com.entidade.*;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String opcao = "1";

		while (!opcao.equals("6")) {
			opcao = JOptionPane.showInputDialog(Funcionalidade.exibirMenu());

			if (opcao == null) {
				opcao = "6";
			}
			if (opcao.equals("1")) {
				JOptionPane.showMessageDialog(null, Funcionalidade.printarProdutos());

			} else if (opcao.equals("2")) {
				cadastrarProduto();

			} else if (opcao.equals("3")) {
				adicionarEstoque();

			} else if (opcao.equals("4")) {
				removerProduto();

			} else if (opcao.equals("5")) {
				venderProduto();

			} else if (opcao.equals("6")) {
				JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema!");

			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
	}

	private static void cadastrarProduto() {
		Produto novoProduto = null;

		String nome = JOptionPane.showInputDialog("Digite o nome do produto");

		String codigo = JOptionPane.showInputDialog("Digite o código do produto");

		if (!Funcionalidade.verificarCodigo(codigo)) {
			JOptionPane.showMessageDialog(null, "Código já existente ou inválido!");

		} else {
			String estoque = JOptionPane.showInputDialog(
					"Deseja estoque? " + "\nDigite a quantidade ou aperte OK para cadastrar o produto sem estoque");
			if(estoque.equals("")) {
				estoque = "0";
			}			
			if (Funcionalidade.tentarInt(estoque)) {
				novoProduto = new Produto(nome, Integer.parseInt(codigo), Integer.parseInt(estoque));
				Funcionalidade.addProduto(novoProduto);
				JOptionPane.showMessageDialog(null, Funcionalidade.printarAtual(nome.toUpperCase(), codigo, estoque));

			} else {
				JOptionPane.showMessageDialog(null, "Estoque inválido!");
			}
		}

	}

	private static void adicionarEstoque() {

	}

	private static void removerProduto() {

	}

	private static void venderProduto() {

	}
}
