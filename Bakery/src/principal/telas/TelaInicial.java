package principal.telas;

import java.util.Scanner;


public class TelaInicial {
	public static void TelaInicial(){
		
		int op;
		
		Scanner leitor = new Scanner(System.in);
		
		do {
			System.out.println("*** Menu ***\nSelecione uma opção: \n[1]Cadastro Pedido\n[2]Ver Cardapio \n[3]Acesso aos Arquivos\n[4]Cadastro Clientes\n[5]Cadastro Funcionarios\n[6]Cadastro Produtos\n[7]Sair");
			 op = leitor.nextInt();
			
			switch(op) {
			case 1:
					TelaPedido.FazerPedido();
				break;
			case 2:
					TelaCardapio.ChamaCardapio();
				break;
			case 3:
					TelaAcesso.TelaAcesso();
				break;
			case 4:
					TelaCliente.CadastraCliente();
				break;
			case 5:
					TelaFuncionario.CadastraFuncionario();
				break;
			case 6:
					TelaProduto.CadastraProduto();
				break;
			case 7:
				break;
			default:
				System.out.println("Opção Invalida!");
			break;
			
			}//switch
			
		}while(op != 7);
		
		leitor.close();
		
	}

}
