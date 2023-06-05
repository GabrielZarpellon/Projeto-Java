package principal.telas;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.daos.ClienteDAO;
import principal.modelos.Cliente;

public class TelaCliente {
	
	static EntityManagerFactory emf;
	static EntityManager em;

	
	public static void CadastraCliente() {
		
		Scanner leitor = new Scanner(System.in);
		int op;
		
		//Criacao/configuracao da persistencia
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
		
		do {
			System.out.println("Menu Cadastro de Clientes: \n [1]Cadastrar Cliente \n[2]Mostrar Clientes \n[3]Atualizar Cliente \n[4]Deletar Cliente \n[5]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Informe o nome da pessoa: ");
				String nome = leitor.next();
				
				System.out.println("Informe o cpf da pessoa:");
				String cpf = leitor.next();
				
				Cliente c = new Cliente(nome, cpf);
				
				Integer id = ClienteDAO.salvar(c);
				System.out.println("Id: " + id);
			
			break;
			
			case 2:
				List<Cliente> clientes = ClienteDAO.listar();
				System.out.println();
				System.out.println("_______________");
				System.out.println("Lista de Clientes:");
				
				for(Cliente cliente : clientes) {
					System.out.println("Ïd: " + cliente.getId() + "     Nome: " + cliente.getNome() + "     Cpf: " + cliente.getCpf());
				}
			
				break;
			
			
			case 3:
				
				System.out.println("Digite o Id da pessoa: ");
				int cli = leitor.nextInt();
				
				Cliente pessoa = ClienteDAO.buscarPorId(cli);
				
				System.out.println("Digite o novo nome: ");
				String novo = leitor.next();
				
				pessoa.setNome(novo);
				ClienteDAO.atualizar(pessoa);
				
				break;
				
			case 4:
				
				System.out.println("Digite o id de quem deseja excluir: ");
				int num = leitor.nextInt();
				
				ClienteDAO.excluir(num);
				
				break;
				
			case 5:
				
				break;
				
			}
		
		}while(op != 5);
		
		leitor.close();
		em.close();
		emf.close();
		
	}

}

