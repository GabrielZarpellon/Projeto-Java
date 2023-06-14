package principal.telas;
import java.time.LocalDateTime;
import java.util.ArrayList;


import principal.daos.PedidoDAO;
import principal.modelos.*;

import java.util.List;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TelaPedido {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
    public static void FazerPedido() {
    	
        Scanner leitor = new Scanner(System.in);
        
        int op;
        
        PedidoDAO pedidoDao = new PedidoDAO();
        
        do {
        	System.out.println("Menu de Pedidos \n[1]Fazer Pedido \n[2]Listar Pedidos  \n[3]Deletar Pedido \n[4]Sair");
        	op = leitor.nextInt();
        	
        	switch(op) {
        	case 1:
        		
        		float ValorTotal = 0;

        		LocalDateTime data = LocalDateTime.now();

                System.out.println("Digite o ID do cliente: ");
                int clienteId = leitor.nextInt();
                leitor.nextLine();

                Cliente cliente = new Cliente(clienteId);

                List<Produto> produtos = new ArrayList<>();

                System.out.println("Digite a quantidade de produtos: ");
                int quantidadeProdutos = leitor.nextInt();
                leitor.nextLine();

                for (int i = 0; i < quantidadeProdutos; i++) {
                    System.out.println("Digite o nome do produto " + (i + 1) + ": ");
                    String nomeProduto = leitor.nextLine();

                    System.out.println("Digite o valor do produto " + (i + 1) + ": ");
                    float valorProduto = leitor.nextFloat();
                    leitor.nextLine();
                    
                    ValorTotal += valorProduto;

                    Produto produto = new Produto(nomeProduto, valorProduto);

                    produtos.add(produto);
                }


                Pedido p = new Pedido(cliente, produtos, ValorTotal);
                
                Integer id = pedidoDao.salvar(p);
				System.out.println("Id: " + id);
                
				break;
        		        	
        	case 2:
        		
        		List<Pedido> pedidos = pedidoDao.listar();
        		
        		for (Pedido pedido : pedidos) {
					
        			System.out.println("Pedido criado:");
                    System.out.println("ID: " + pedido.getId());
                    System.out.println("Data: " + pedido.getData());
                    System.out.println("ID do cliente: " + pedido.getCliente().getId());
                    System.out.println("Produtos: ");
                    for (Produto produto : pedido.getProdutos()) {
                        System.out.println("- " + produto.getNome() + ", Valor: " + produto.getPreco());
                    }
                    System.out.println("Valor total: " + pedido.getValor());
                    System.out.println();
            		System.out.println("____________________________________________________");
        			
				}
        	
        		
        		break;

        		
        	case 3:
        		
        		System.out.println("Digite o Id do pedido que deseja excluir: ");
				int num = leitor.nextInt();
				
				pedidoDao.excluir(num);
        		
        		break;
        		
        	case 4:
        		
        		break;
        	
        	
        	}
        	
        }while(op != 4);

        
        leitor.close();
        pedidoDao.close();
    }
}
