package up.Persistencia;

import java.util.ArrayList;

import up.Entidades.Cliente;
import up.Entidades.Vendedor;
import up.Entidades.Produto;
import up.Entidades.Venda;
import up.Entidades.Item;

public class Persistencia {
	static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	static ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
	public static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	public static ArrayList<Item> listaItens = new ArrayList<Item>();
	
	public static Cliente verificarCCPF(Cliente a) {
		for(Cliente item : listaClientes) {
			if(item.getCpf().equals(a.getCpf())){
				return item;
			}
		}
		return null;
	}
	
	public static Cliente verificarCnome(Venda a) {
		for(Cliente item: listaClientes) {
			if (item.getNome().equals(a.getCliente())) {
				return item;
			}
		}
		return null;
	}
	
	public static void adicionarClista(Cliente a) {
		listaClientes.add(a);
	}
	
	public static Vendedor verificarVCPF(Vendedor a) {
		for(Vendedor item: listaVendedores) {
			if(item.getCpf().equals(a.getCpf())) {
				return item;
			}
		}
		return null;
	}
	
	public static Vendedor verificarVnome(Venda a) {
		for (Vendedor item: listaVendedores) {
			if(item.getNome().equals(a.getVendedor())) {
				return item;
			}
		}
		return null;
	}
	
	public static void adicionarVlista(Vendedor a) {
		listaVendedores.add(a);
	}
	
	public static Produto verificarP(Produto a) {
		for(Produto item: listaProdutos) {
			if (item.getNome().equals(a.getNome())) {
				return item;
			}
		}
		return null;
	}
	
	public static void adicionarPlista(Produto a) {
		listaProdutos.add(a);
	}
	
	public static void adicionarIlista(Item a) {
		listaItens.add(a);
	}
	
	public static Produto verificarIlistaP (Item a) {
		for (Produto item: listaProdutos) {
			if(item.getNome().equals(a.getProduto())) {
				return item;
			}
		}
		return null;
	}
	
	public static void adicionarVendalista(Venda a) {
		listaVendas.add(a);
	}
	
	public static Item verificarPlistaI(Item a) {
		for(Item item: listaItens) {
			if(item.getProduto().equals(a.getProduto())) {
				return item;
			}
		}
		return null;
	}
}