package up.Entidades;

public class Produto {
	private String nome;
	private float preco;
	private float markup;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getMarkup() {
		return markup;
	}
	public void setMarkup(float markup) {
		this.markup = markup;
	}
}