package principal.telas;
import java.io.FileNotFoundException;
import java.util.Scanner;
import principal.daos.CardapioDAO;


public class TelaInicial {
	public static void TelaInicial() throws FileNotFoundException {
		
		int op;
		
		Scanner leitor = new Scanner(System.in);
		
		do {
			System.out.println("*** Menu ***\nSelecione uma opção: \n[1]Fazer Pedido\n[2]Ver Cardapio \n[3]Acesso aos Arquivos\n[4]Cadastro Clientes\n[5]Cadastro Funcionarios\n[6]Cadastro Produtos\n[7]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
				
				break;
			case 2:
					CardapioDAO.Cardapio();
				break;
			case 3:
					TelaAcesso.TelaAcesso(leitor);
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
