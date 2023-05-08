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
import funcao.FuncaoListaEstoque;
import funcao.FuncaoPedido;

public class Programa {
	public static void main(String[] args) throws FileNotFoundException {
		
		int op; int acesso;
		
		Scanner leitor = new Scanner(System.in);
		
		//Criando as funcoes
		
		FuncaoProd Cardapio = new FuncaoProd();
		FuncaoCliente HistoricoClientes = new FuncaoCliente();
		FuncaoFuncionario ArquivoFuncionarios = new FuncaoFuncionario();
		FuncaoListaEstoque ControleEstoque = new FuncaoListaEstoque();
		FuncaoPedido RealizarPedido = new FuncaoPedido();
		
		//Loop Menu Principal
		
		do {
			System.out.println("*** Menu ***\nSelecione uma opção: \n[1]Fazer Pedido\n[2]Ver Cardapio \n[3]Acesso aos Arquivos\n[4]Controle do Estoque \n[5]Sair");
			op = leitor.nextInt();
			
			switch(op) {
				case 1:
						RealizarPedido.FazerPedido();
					break;
				
				case 2:
						Cardapio.LerProdutos();
					break;
					
				case 3:
					leitor.nextLine();
					System.out.println("Informe a senha de acesso: ");
					String senha = leitor.nextLine();
			
						if(senha.equals("Permitido")) {
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

								}while(acesso != 4);//do
							
						}else {
							System.out.println("Acesso Negado, Senha incorreta!");
						}
	
					break;
				
				case 4:
						ControleEstoque.MenuEstoque();
					break;
			
				case 5:
					break;
				
				default:
					System.out.println("Opção Invalida!");
				break;
			}//switch
			
		}while(op != 5);
		
	}
}

