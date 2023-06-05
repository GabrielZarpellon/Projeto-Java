package principal.telas;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.daos.ProdutoDAO;
import principal.modelos.Produto;

public class TelaProduto {

		
		static EntityManagerFactory emf;
		static EntityManager em;

		
		public static void CadastraProduto() {
			
			Scanner leitor = new Scanner(System.in);
			int op;
			
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
					
					Integer id = ProdutoDAO.salvar(p);
					System.out.println("Id: " + id);
				
				break;
				
				
				case 2:
					
					System.out.println("Digite o Id do produto: ");
					int prod = leitor.nextInt();
					
					Produto produto = ProdutoDAO.buscarPorId(prod);
					
					System.out.println("Digite o novo nome: ");
					String novo = leitor.next();
					
					produto.setNome(novo);
					ProdutoDAO.atualizar(produto);
					
					break;
					
				case 3:
					
					System.out.println("Digite o id do produto que deseja excluir: ");
					int num = leitor.nextInt();
					
					ProdutoDAO.excluir(num);
					
					break;
					
				case 4:
					break;
					
				}
				
			
			}while(op != 4);
			
			leitor.close();
			em.close();
			emf.close();
			
		}

}
