package principal.telas;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class TelaAcesso {
	public static void TelaAcesso(Scanner leitor) throws FileNotFoundException{
		
		int acesso;
		
		leitor.nextLine();
		System.out.println("Informe a senha de acesso: ");
		String senha = leitor.nextLine();
		
		if(senha.equals("Permitido")) {
			do {
				System.out.println("Informe o que gostaria de acessar: \n[1]Historico de Clientes \n[2]Historico de pedidos \n[3]Arquivo de Funcionarios \n[4]Sair");
				acesso = leitor.nextInt();
				
				switch(acesso) {
				case 1:
						//LerFuncionario.LerClientes();
					break;
				case 2:

					break;
				case 3:
						
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
