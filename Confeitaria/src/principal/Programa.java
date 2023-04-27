package principal;
import java.util.Scanner;
import principal.modelos.Pessoa;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import funcao.FuncaoProd;

import java.io.File;
import java.io.FileNotFoundException;
import principal.modelos.Funcionario;
import principal.modelos.Cliente;
import principal.modelos.Produto;
import principal.modelos.Item_Pedido;
import principal.modelos.Estoque;
import principal.modelos.Pedido;
import funcao.FuncaoCliente;
import funcao.FuncaoFuncionario;
import funcao.FuncaoEstoque;

public class Programa {
	public static void main(String[] args) throws FileNotFoundException {
		
		int op; int acesso;
		
		Scanner leitor = new Scanner(System.in);
		
		FuncaoProd Cardapio = new FuncaoProd();
		
		FuncaoCliente HistoricoClientes = new FuncaoCliente();
		
		FuncaoFuncionario ArquivoFuncionarios = new FuncaoFuncionario();
		
		Estoque Bolo = new Estoque("Bolo de Cenoura", 12);
		Estoque agua = new Estoque("agua", 40);
		
		FuncaoEstoque lista = new FuncaoEstoque();
		
		lista.adicionar(Bolo);
		lista.adicionar(agua);
		
		
		do {
			System.out.println("___Menu___\n Selecione uma opção: \n[1]Fazer Pedido\n[2]Ver Cardapio \n[3]Acesso aos Arquivos\n[4]Listar Estoque \n[5]Sair");
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
					do {
					System.out.println("Informe o que gostaria de acessar: \n[1]Historico de Clientes \n[2]Historico de pedidos \n[3]Arquivo de Funcionarios \n[4]Sair");
					acesso = leitor.nextInt();
										
					switch(acesso) {
					case 1:
							HistoricoClientes.LerClientes();
						break;
					case 2:
						
						break;
					case 3:
							ArquivoFuncionarios.LerFuncionario();
						break;
					case 4:
						
						break;
					
					}//switch

					}while(acesso != 4);
				}else {
					System.out.println("Acesso Negado, Senha incorreta!");
				}
				
				
				break;
				
			case 4:
					List<Estoque> lista2 = lista.getProdutos();
					for(int i = 0; i < lista2.size(); i++) {
						Estoque estoque = lista2.get(i);
						System.out.println("Ingrediente: " + estoque.getNome() + "\nQuantidade: " + estoque.getQuantidade());
					}
				
				break;
			
			case 5:
					
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

