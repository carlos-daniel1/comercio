package com;

import java.util.Scanner;

public class Main {

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 1;

		while (opcao != 6) {
			exibirMenu();
			opcao = entrada.nextInt();
			entrada.nextLine();

			if (opcao == 1) {
				listarProdutos();
			} else if (opcao == 2) {
				cadastrarProduto();
			} else if (opcao == 3) {
				adicionarEstoque();
			} else if (opcao == 4) {
				removerProduto();
			} else if (opcao == 5) {
				venderProduto();
			} else if (opcao == 6) {
				System.out.println("Saindo do programa.");
			} else {
				System.out.println("Opção inválida, escolha uma opção válida.");
			}
		}
	}

	private static void exibirMenu() {
		System.out.println("\n1) Listar todos os produtos");
		System.out.println("2) Cadastrar novo produto");
		System.out.println("3) Adicionar estoque de um produto");
		System.out.println("4) Remover produto");
		System.out.println("5) Vender produto");
		System.out.println("6) Sair");
		System.out.print("\nEscolha uma opção: ");
	}

	public static void listarProdutos() {

		
	}

	private static void cadastrarProduto() {


	}

	private static void adicionarEstoque() {
		
	}

	private static void removerProduto() {

	}

	private static void venderProduto() {
		
		 
	}
}
