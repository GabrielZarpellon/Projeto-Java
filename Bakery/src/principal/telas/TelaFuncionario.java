package principal.telas;

import java.util.Scanner;




import java.util.List;

import principal.daos.FuncionarioDAO;
import principal.modelos.Funcionario;

public class TelaFuncionario {
	
	
	public static void CadastraFuncionario() {
		
		Scanner leitor = new Scanner(System.in);
		int op;
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		
		do {
			
			System.out.println("Menu Cadastro de Funcionarios: \n[1]Cadastrar Funcionarios \n[2]Atualizar Funcionario \n[3]Deletar Funcionario \n[4]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Informe o nome do Funcionario: ");
				String nome = leitor.next();
				
				System.out.println("Digite o CPF:");
				String cpf = leitor.next();
				
				System.out.println("Digite a Funcao: ");
				String funcao = leitor.next();
				
				System.out.println("Digite o periodo: ");
				String periodo = leitor.next();
				
				System.out.println("Digite o salario: ");
				double salario = leitor.nextDouble();
				
				Funcionario f = new Funcionario(nome, cpf, funcao, periodo, salario);
				
				Integer id = funcionarioDao.salvar(f);
				System.out.println("Id: " + id);
				
				break;
				
				
			case 2:
				
				System.out.println("Digite o Id do Funcionario: ");
				int func = leitor.nextInt();
				
				Funcionario funcionario = funcionarioDao.buscarPorId(func);
				
				System.out.println("Digite o novo nome: ");
				String novo = leitor.next();
				
				funcionario.setNome(novo);
				funcionarioDao.atualizar(funcionario);
				
				break;
				
			case 3:
				
				System.out.println("Digite o Id de quem deseja excluir: ");
				int num = leitor.nextInt();
				
				funcionarioDao.excluir(num);
				
				break;
				
			case 4:
				break;
				
			}
			
			
		}while(op != 4);
		
		leitor.close();
		funcionarioDao.close();
		
	}
	

}
