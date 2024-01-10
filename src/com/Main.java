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
				venderProduto();

			} else if (opcao.equals("5")) {
				removerProduto();

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
		if (nome == null)
			return;

		String codigo = JOptionPane.showInputDialog("Digite o código do produto");
		if (codigo == null)
			return;

		if (!Funcionalidade.verificarCodigo(codigo)) {
			JOptionPane.showMessageDialog(null, "Código já existente ou inválido!");

		} else {
			String estoque = JOptionPane.showInputDialog(
					"Deseja estoque? " + "\nDigite a quantidade ou aperte OK para cadastrar o produto sem estoque");
			if (estoque == null)
				return;

			if (estoque.equals("") || estoque.contains("-")) {
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
		if (Funcionalidade.sizeListaProdutos() > 0) {

			String codigo = JOptionPane.showInputDialog(null,
					Funcionalidade.printarProdutos() + "Digite o código do produto que deseja adicionar estoque: ");

			Produto produto = Funcionalidade.retornarProduto(codigo);

			if (produto != null) {
				String quantidade = JOptionPane.showInputDialog("Digite a quantidade a ser adicionada: ");

				if (Funcionalidade.verificarQuantidade(quantidade)) {
					produto.setEstoque(produto.getEstoque() + Integer.parseInt(quantidade));

					JOptionPane.showMessageDialog(null, String.format("%s atualizado com sucesso. \nNovo estoque: %d",
							produto.getNome(), produto.getEstoque()));

				} else {
					JOptionPane.showMessageDialog(null, "Quantidade inválida!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Cadastre produtos para adicionar estoque!");
		}

	}

	private static void venderProduto() {
		if (Funcionalidade.sizeListaProdutos() > 0) {
			String codigo = JOptionPane.showInputDialog(null,
					Funcionalidade.printarProdutos() + "Digite o código do produto que deseja vender estoque: ");
			
			Produto produto = Funcionalidade.retornarProduto(codigo);
			
			if(produto != null) {
				String quantidade = JOptionPane.showInputDialog(String.format("%s (Estoque: %d)", produto.getNome().
						toUpperCase(), produto.getEstoque()) + "\nDigite a quantidade que deseja vender: ");
				
				if(Funcionalidade.verificarVenda(quantidade, produto)) {
					produto.setEstoque(produto.getEstoque() - Integer.parseInt(quantidade));
					
					JOptionPane.showMessageDialog(null, String.format("%s vendido com sucesso! "
							+ "Estoque atualizado: %d", produto.getNome(), produto.getEstoque()));	
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade inválida!");
				}			
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados para vender!");

		}
	}

	private static void removerProduto() {
		if (Funcionalidade.sizeListaProdutos() > 0) {
			String codigo = JOptionPane.showInputDialog(null,
					Funcionalidade.printarProdutos() + "Digite o código do produto que deseja remover da loja: ");
			Produto produto = Funcionalidade.retornarProduto(codigo);

			if (produto != null) {
				if (produto.getEstoque() > 0) {
					int confirmacao = JOptionPane.showConfirmDialog(null,
							String.format("Deseja realmente remover o produto %s? Se sim, aperte YES",
									produto.getNome().toUpperCase()),
							"Confirmação", JOptionPane.YES_NO_OPTION);

					if (confirmacao == 1) {
						JOptionPane.showMessageDialog(null, "Operação cancelada!");
						return;
					}
				}
				JOptionPane.showMessageDialog(null,
						String.format("%s removido com sucesso!", produto.getNome()));
				Funcionalidade.removerProduto(produto);
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados para remover!");
		}
	}
}
