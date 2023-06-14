package principal.telas;

import java.util.Scanner;

import principal.daos.ProdutoDAO;
import principal.modelos.Produto;

public class TelaProduto {
		
		public static void CadastraProduto() {
			
			Scanner leitor = new Scanner(System.in);
			int op;
			
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			do {
				System.out.println("Menu Cadastro de Produtos: \n [1]Cadastrar Produto \n[2]Atualizar Produto \n[3]Deletar Produto \n[4]Sair");
				op = leitor.nextInt();
				
				switch(op) {
				case 1:
					System.out.println("Informe o nome do produto: ");
					String nome = leitor.next();
					
					System.out.println("Informe o preco:");
					double preco = leitor.nextDouble();
					
					System.out.println("Informe o tipo:");
					String tipo = leitor.next();
					
					Produto p = new Produto(nome, preco, tipo);
					
					Integer id = produtoDao.salvar(p);
					System.out.println("Id: " + id);
				
				break;
				
				
				case 2:
					
					System.out.println("Digite o Id do produto: ");
					int prod = leitor.nextInt();
					
					Produto produto = produtoDao.buscarPorId(prod);
					
					System.out.println("Digite o novo nome: ");
					String novo = leitor.next();
					
					produto.setNome(novo);
					produtoDao.atualizar(produto);
					
					break;
					
				case 3:
					
					System.out.println("Digite o id do produto que deseja excluir: ");
					int num = leitor.nextInt();
					
					produtoDao.excluir(num);
					
					break;
					
				case 4:
					break;
					
				}
				
			
			}while(op != 4);
			
			leitor.close();
			produtoDao.close();
			
		}

}
