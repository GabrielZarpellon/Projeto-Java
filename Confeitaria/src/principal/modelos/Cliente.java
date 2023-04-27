package principal.modelos;

	public class Cliente extends Pessoa {
		
		private int idCliente;
		
		
	public Cliente() {
	}

	
	public Cliente(String nome , String telefone) {
		super(nome, telefone);
	}
	
	public Cliente(String nome, String telefone, int idCliente) {
		super(nome,telefone);
		this.idCliente = idCliente;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
}

