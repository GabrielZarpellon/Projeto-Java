package principal.modelos;

public class Item_Pedido {
	
	private int quantidade;
	private double valorUnitario;
	private double valorTotal;
	
	public Item_Pedido() {
		
	}
	
	public Item_Pedido(int quantidade, double valorUnitario, double valorTotal) {
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
