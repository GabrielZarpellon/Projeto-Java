package principal.modelos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Pedido {
	private int id_pedido;
	private Date data;
	private double valorTotal;
	private List<Item_Pedido> Itens_Pedidos = new ArrayList<>();
	
	public void adicionar(Item_Pedido Item_Pedido) {
		this.Itens_Pedidos.add(Item_Pedido);
	}
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Item_Pedido> getItens_Pedidos() {
		return Itens_Pedidos;
	}

	public void setItens_Pedidos(List<Item_Pedido> itens_Pedidos) {
		Itens_Pedidos = itens_Pedidos;
	}
	
}
