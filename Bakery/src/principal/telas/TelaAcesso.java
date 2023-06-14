package principal.telas;



import java.util.List;
import java.util.Scanner;

import principal.daos.ClienteDAO;
import principal.daos.FuncionarioDAO;
import principal.daos.PedidoDAO;
import principal.modelos.Cliente;
import principal.modelos.Funcionario;
import principal.modelos.Pedido;
import principal.modelos.Produto;

public class TelaAcesso {
	public static void TelaAcesso() {
		
		Scanner leitor = new Scanner(System.in);
		
		int acesso;
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		ClienteDAO clienteDao = new ClienteDAO();
		PedidoDAO pedidoDao = new PedidoDAO();
		
		System.out.println();
		System.out.println("____________________________________________________");
		System.out.println("Informe a senha de acesso: ");
		String senha = leitor.nextLine();
		
		if(senha.equals("Permitido")) {
			do {
				System.out.println("Informe o que gostaria de acessar: \n[1]Historico de Clientes \n[2]Historico de pedidos \n[3]Arquivo de Funcionarios \n[4]Sair");
				acesso = leitor.nextInt();
				
				switch(acesso) {
				case 1:
					List<Cliente> clientes = clienteDao.listar();
					System.out.println();
					System.out.println("_______________");
					System.out.println("Lista de Clientes:");
					
					for(Cliente cliente : clientes) {
						System.out.println("Ïd: " + cliente.getId() + "     Nome: " + cliente.getNome() + "     Cpf: " + cliente.getCpf());
						System.out.println();
	            		System.out.println("____________________________________________________");
					}
				
					break;
				case 2:
					
					List<Pedido> pedidos = pedidoDao.listar();
	        		
	        		for (Pedido pedido : pedidos) {
						
	        			System.out.println("Pedido criado:");
	                    System.out.println("ID: " + pedido.getId());
	                    System.out.println("Data: " + pedido.getData());
	                    System.out.println("ID do cliente: " + pedido.getCliente().getId());
	                    System.out.println("Produtos: ");
	                    for (Produto produto : pedido.getProdutos()) {
	                        System.out.println("- " + produto.getNome() + ", Valor: " + produto.getPreco());
	                    }
	                    System.out.println("Valor total: " + pedido.getValor());
	                    System.out.println();
	            		System.out.println("____________________________________________________");
	        			
					}

					break;
				case 3:
					List<Funcionario> funcionarios = funcionarioDao.listar();
					System.out.println();
					System.out.println("Lista de Funcionarios: ");
					
					for(Funcionario funcionario : funcionarios) {
						System.out.println("Id: " + funcionario.getId() + " Nome: " + funcionario.getNome() + " Cpf: " + funcionario.getCpf() + " Funcao: " + funcionario.getFuncao() + " Periodo: " + funcionario.getPeriodo() + " Salario: " + funcionario.getSalario());
						System.out.println();
	            		System.out.println("____________________________________________________");
					}
					
					break;
				case 4:
					break;
					default:
						System.out.println("Informe uma opção valida!");
						break;
				}
				
				
			}while(acesso != 4);
		
		}else {
			System.out.println("Acesso Negado, Senha incorreta!");
		}	
		
		
		leitor.close();
	}
}
