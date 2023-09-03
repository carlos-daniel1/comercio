

/*
 * Carlos Daniel 
 * Luiz Neto Márcio Vitor 
 * Pedro Henrique 
 * Ramon Gonçalves 
 * Sairo Soares 
 * Vinicius Cândido
 */

import java.util.ArrayList;
import java.util.Scanner;

class Produto {
	String nome;
	int codigo;
	int estoque;

	public Produto(String nome, int codigo, int estoque) {
		this.nome = nome;
		this.codigo = codigo;
		this.estoque = estoque;
	}
}

public class Comercio {
	private static ArrayList<Produto> ListaProdutos = new ArrayList<Produto>();
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

		if (ListaProdutos.isEmpty()) {
			System.out.println("Não existem produtos cadastrados");
			return;
		} else {
			for (Produto produto : ListaProdutos) {
				System.out
						.println(produto.nome + " ( Cód.: " + produto.codigo + " | estoque: " + produto.estoque + " )");

			}

		}

	}

	private static void cadastrarProduto() {
		System.out.print("Digite o nome do produto: ");
		String nome = entrada.nextLine();

		int codigo;
		do {

			System.out.print("Digite o código do produto: ");
			codigo = entrada.nextInt();

			if (verificacao(codigo)) {
				System.out.println("Código já cadastrado");
				return;
			}

		} while (verificacao(codigo));
		int estoque;

		System.out.print("Deseja adicionar estoque? 1)Sim 2)Não \nDigite: ");
		int desejaEstoque = entrada.nextInt();

		if (desejaEstoque == 1) {
			System.out.print("Digite o estoque do produto: ");
			estoque = entrada.nextInt();
			ListaProdutos.add(new Produto(nome, codigo, estoque));

		} else {
			estoque = 0;
			ListaProdutos.add(new Produto(nome, codigo, estoque));
		}

		System.out.println("Produto cadastrado com sucesso!");
		System.out.println(nome + " ( Cód.: " + codigo + " | estoque: " + estoque + " )");

	}

	private static void adicionarEstoque() {
		if (ListaProdutos.isEmpty()) {
			System.out.println("Não existem produtos cadastrados.");
			return;
		}

		listarProdutos();

		System.out.print("Digite o código do produto que deseja adicionar estoque: ");
		int codigo = entrada.nextInt();

		for (Produto produto : ListaProdutos) {
			if (produto.codigo == codigo) {
				System.out.print("Quantidade a ser adicionada: ");
				int adicionarEstoque = entrada.nextInt();
				produto.estoque += adicionarEstoque;
				System.out.println("Estoque atualizado com sucesso.");
				return;
			}
		}
		System.out.println("Código inválido.");
	}

	private static void removerProduto() {

		if (ListaProdutos.isEmpty()) {
			System.out.println("Não existem produtos cadastrados para remover");
			return;
		}

		System.out.print("Digite o código do produto que deseja remover: ");
		int codigo = entrada.nextInt();

		for (Produto produto : ListaProdutos) {

			if (produto.codigo == codigo) {
				if (produto.estoque > 0) {

					System.out.printf("Deseja realmente remover o produto com "
							+ "código %d? \n1) Remover produto 2) Voltar \nDigite: ", produto.codigo);
					int confirmar = entrada.nextInt();

					if (confirmar == 1) {
						ListaProdutos.remove(produto);
						System.out.println("Produto removido com sucesso!");
						return;
					} else {
						System.out.println("Menu");
						return;
					}

				} else {
					ListaProdutos.remove(produto);
					System.out.println("Produto removido com sucesso!");
					return;
				}

			} else {
				System.out.println("Código inválido!");
				return;
			}
		}
	}

	private static void venderProduto() {
		if (ListaProdutos.isEmpty()) {
			System.out.println("Não existem produtos cadastrados para vender");
			return;
		}

		System.out.print("Digite o código do produto que deseja vender: ");
		int codigo = entrada.nextInt();

		for (Produto produto : ListaProdutos) {
			if (produto.codigo == codigo) {
				System.out.print("Digite a quantidade que será  a ser vendida: ");
				int quantidadeVendida = entrada.nextInt();

				if (quantidadeVendida <= produto.estoque) {
					produto.estoque -= quantidadeVendida;
					System.out.println("Venda realizada com sucesso! Estoque atualizado");
				} else {
					System.out.println("Quantidade insuficiente em estoque.");
					return;
				}

			} else {
				System.out.println("Código inválido");
				return;
			}
		}
		System.out.println("Código inválido");
	}

	private static boolean verificacao(int codigo) {
		for (Produto produto : ListaProdutos) {
			if (produto.codigo == codigo) {
				return true;
			}
		}
		return false;
	}
}
