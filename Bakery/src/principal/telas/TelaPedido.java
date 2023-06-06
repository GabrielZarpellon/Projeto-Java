package principal.telas;

import java.util.List;
import java.util.Scanner;

import principal.daos.PedidoDAO;
import principal.modelos.Cliente;
import principal.modelos.Produto;

public class TelaPedido {
	
	public void CadastraPedido() {
		
		Scanner leitor = new Scanner(System.in);
		int op;
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		do {
			System.out.println("Menu Cadastro de Produtos: \n [1]Fazer Pedido \n[2]Atualizar Pedido \n[3]Deletar Pedido \n[4]Sair");
			op = leitor.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Informe a data: ");
				String data = leitor.next();
				
				System.out.println("Informe o cliente:");
				//Cliente cliente = leitor.next();
				
				System.out.println("Informe o id dos itens:");
				int itens = leitor.nextInt();
				
			
				
			
				
			case 4:
				break;
				
			}
			
		
		}while(op != 4);
		
		leitor.close();
		pedidoDAO.close();
		
		
		
		
		
		
	}
	

}
