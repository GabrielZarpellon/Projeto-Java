package funcao;

import java.util.Scanner;

import principal.modelos.Funcionario;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import principal.modelos.Item_Pedido;
import funcao.FuncaoFuncionario;
import java.util.Formatter;

public class FuncaoPedido {
	
	public static void FazerPedido() throws FileNotFoundException  {
		
		String Func = "C:\\Mari\\Confeitaria\\src\\arquivosTxt\\Funcionarios";
		String Cli = "C:\\Mari\\Confeitaria\\src\\arquivosTxt\\Clientes";
		String Ped = "C:\\Mari\\Confeitaria\\src\\arquivosTxt\\Pedidos";
		File Funcionario = new File (Func);
		File Cliente = new File(Cli);
		File Pedido = new File(Ped);
		Scanner leitorFun = new Scanner(Funcionario);
		Scanner leitorCli = new Scanner(Cliente);
		
		Formatter gravador = new Formatter(Pedido);
		
		Scanner leitor = new Scanner (System.in);
		
		
		Item_Pedido Total = new Item_Pedido();
		
		
		Funcionario[] vetorDeFuncionarios = new Funcionario[5];
		
		int cont = 0;
		
		while(leitorFun.hasNextLine()) {
			
			try {
				String linha = leitorFun.nextLine();
				String[] valores = linha.split("\t");
				
				Funcionario f = new Funcionario();
				f.setIdFuncionario(Integer.parseInt(valores[0]));
				f.setNome(valores[1]);
				f.setTelefone(valores[2]);
				f.setFuncao(valores[3]);
				f.setPeriodo(valores[4]);
				f.setSalario(Double.parseDouble(valores[5]));
				
				vetorDeFuncionarios[cont] = f;
				cont++;
				}catch(NumberFormatException e) {
					System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
				}
			}
			
		System.out.println("Informe o id do Pedido: ");
		int idPedido = leitor.nextInt();
		gravador.format(idPedido + ",");
		
		System.out.println("Informe o id do Funcionario: ");
		int idFuncionario = leitor.nextInt();
		gravador.format(idFuncionario + ",");
		
		System.out.println("Informe o id do Cliente: ");
		int idCliente = leitor.nextInt();
		gravador.format(idCliente + ",");
		
		String op;
		
		double total = 0;
		do {
			System.out.println("Informe o item: ");
			String item = leitor.next();
			gravador.format(item + ",");

			
			System.out.println("Informe o valor unitario:");
			double uni = leitor.nextDouble();
			gravador.format(uni + ",");

			
			System.out.println("Infome a quantidade: ");
			int qntd = leitor.nextInt();
			gravador.format(qntd + ",");

			
			total += (uni * qntd);
			
			System.out.println("Deseja adicionar mais itens? ");
			op = leitor.next();
			
			
		}while(op.equals("s"));
		
		System.out.println("Valor total: " + total);	
		gravador.format(total + ",");

		
		gravador.close();
		
		//System.out.println("Valor total: " + Item_Pedido.());
		
	}
	
}
