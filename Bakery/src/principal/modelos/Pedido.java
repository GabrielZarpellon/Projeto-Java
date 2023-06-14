package principal.modelos;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime data;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Produto> produtos;
	
	private float valor;
	
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente, List<Produto> produtos, float valor) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.valor = valor;
	}

	public Pedido(int id, Cliente cliente, List<Produto> produtos, float valor) {
		super();
		this.data = LocalDateTime.now();
		this.cliente = cliente;
		this.produtos = produtos;
		this.valor = valor;
	}
	
	public Pedido(int id, String data, Cliente cliente, List<Produto> produtos, float valor) {
		super();
		this.id = id;
		this.data = LocalDateTime.now();
		this.cliente = cliente;
		this.produtos = produtos;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	
	
	
}