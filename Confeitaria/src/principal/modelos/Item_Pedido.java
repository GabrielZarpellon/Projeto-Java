package principal.modelos;

public class Item_Pedido {
	
	
	private int quantidade;
	private double valorUnitario;
	
	public double getValorTotal() {
		return quantidade * valorUnitario;
	}
	
	public Item_Pedido() {
		
	}
	
	public Item_Pedido(int quantidade, double valorUnitario, double valorTotal) {
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	
	

}
