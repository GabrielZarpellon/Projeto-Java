package principal.telas;

import java.util.Scanner;


import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import principal.daos.FuncionarioDAO;
import principal.modelos.Funcionario;

public class TelaFuncionario {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void CadastraFuncionario() {
		
		Scanner leitor = new Scanner(System.in);
		int op;
		
		
		do {
			
			System.out.println("Menu Cadastro de Funcionarios: \n[1]Cadastrar Funcionarios \n[2]Listar Funcionarios \n[3]Atualizar Funcionario \n[4]Deletar Funcionario \n[5]Sair");
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
				
				Integer id = FuncionarioDAO.salvar(f);
				System.out.println("Id: " + id);
				
				break;
				
			case 2:
				List<Funcionario> funcionarios = FuncionarioDAO.listar();
				System.out.println();
				System.out.println("Lista de Funcionarios: ");
				
				for(Funcionario funcionario : funcionarios) {
					System.out.println("Id: " + funcionario.getId() + "Nome: " + funcionario.getNome() + "Cpf: " + funcionario.getCpf() + "Funcao: " + funcionario.getFuncao() + "Periodo: " + funcionario.getPeriodo() + "Salario: " + funcionario.getSalario());
				}
				
				break;
				
			case 3:
				
				System.out.println("Digite o Id do Funcionario: ");
				int func = leitor.nextInt();
				
				Funcionario funcionario = FuncionarioDAO.buscarPorId(func);
				
				System.out.println("Digite o novo nome: ");
				String novo = leitor.next();
				
				funcionario.setNome(novo);
				FuncionarioDAO.atualizar(funcionario);
				
				break;
				
			case 4:
				
				System.out.println("Digite o Id de quem deseja excluir: ");
				int num = leitor.nextInt();
				
				FuncionarioDAO.excluir(num);
				
				break;
				
			case 5:
				break;
				
			}
			
			
		}while(op != '5');
		
		leitor.close();
		em.close();
		emf.close();
	}
	

}
