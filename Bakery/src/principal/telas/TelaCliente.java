package principal.telas;

import java.util.List;


import java.util.Scanner;


import principal.daos.ClienteDAO;
import principal.modelos.Cliente;

public class TelaCliente {
	
	
	public static void CadastraCliente() {
		
		Scanner leitor = new Scanner(System.in);
		int op;
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		
		do {
			System.out.println("Menu Cadastro de Clientes: \n [1]Cadastrar Cliente \n[2]Atualizar nome Cliente \n[3]Deletar Cliente \n[4]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Informe o nome da pessoa: ");
				String nome = leitor.next();
				
				System.out.println("Informe o cpf da pessoa:");
				String cpf = leitor.next();
				
				Cliente c = new Cliente(nome, cpf);
				
				Integer id = clienteDao.salvar(c);
				System.out.println("Id: " + id);
			
			break;
			
//			case 2:
//				List<Cliente> clientes = clienteDao.listar();
//				System.out.println();
//				System.out.println("_______________");
//				System.out.println("Lista de Clientes:");
//				
//				for(Cliente cliente : clientes) {
//					System.out.println("Ïd: " + cliente.getId() + "     Nome: " + cliente.getNome() + "     Cpf: " + cliente.getCpf());
//				}
//			
//				break;
			
			
			case 2:
				
				System.out.println("Digite o Id da pessoa: ");
				int cli = leitor.nextInt();
				
				Cliente pessoa = clienteDao.buscarPorId(cli);
				
				System.out.println("Digite o novo nome: ");
				String novo = leitor.next();
				
				pessoa.setNome(novo);
				clienteDao.atualizar(pessoa);
				
				break;
				
			case 3:
				
				System.out.println("Digite o id de quem deseja excluir: ");
				int num = leitor.nextInt();
				
				clienteDao.excluir(num);
				
				break;
				
			case 4:
				
				break;
				
			}
		
		}while(op != 4);
		
		leitor.close();
		clienteDao.close();
		
	}

}

