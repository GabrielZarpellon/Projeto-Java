package principal;
import java.util.Scanner;
import principal.modelos.Pessoa;
import java.util.Scanner;

import Funcao.FuncaoProd;

import java.io.File;
import java.io.FileNotFoundException;
import principal.modelos.Funcionario;
import principal.modelos.Cliente;
import principal.modelos.Produto;
import principal.modelos.Item_Pedido;
import principal.modelos.Estoque;
import principal.modelos.Pedido;
import Funcao.FuncaoCliente;
import Funcao.FuncaoFuncionario;

public class Programa {
	public static void main(String[] args) throws FileNotFoundException {
		
		int op;
		
		Scanner leitor = new Scanner(System.in);
		
		FuncaoProd Cardapio = new FuncaoProd();
		
		FuncaoCliente HistoricoClientes = new FuncaoCliente();
		
		FuncaoFuncionario ArquivoFuncionarios = new FuncaoFuncionario();
		
		do {
			System.out.println("___Menu___\n Selecione uma opção: \n[1]Fazer Pedido\n[2]Ver Cardapio \n[3]Acesso aos Arquivos\n[4]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
					
				break;
				
			case 2:
					Cardapio.LerProdutos();
				break;
				
			case 3:
				leitor.nextLine();
				System.out.println("Informe a senha de acesso: ");
				String senha = leitor.nextLine();
				
				if(senha.equals("acessoPermitido")) {
					System.out.println("Informe o que gostaria de acessar: \n[1]Historico de Clientes \n[2]Historico de pedidos \n[3]Arquivo de Funcionarios \n[4]Sair");
					int acesso = leitor.nextInt();
					
					switch(acesso) {
					case 1:
							HistoricoClientes.LerClientes();
						break;
					case 2:
						
						break;
					case 3:
							ArquivoFuncionarios.LerFuncionario();
						break;
					}//switch

				}else {
					System.out.println("Acesso Negado, Senha incorreta!");
				}
				
				break;
				
			case 4:
				break;
			default:
				System.out.println("Opção Invalida!");
			break;
			}
			
		}while(op != 4);
		
		
		}
	}
	
	//Mostrar o cardapio
			//Cardapio.LerProdutos();
			
			//Mostrar Historico de Clientes
			//HistoricoClientes.LerClientes();
			
			//Mostrar Arquivo de Funcionarios
			//ArquivoFuncionarios.LerFuncionario();

