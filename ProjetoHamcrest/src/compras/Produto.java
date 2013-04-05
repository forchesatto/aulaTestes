package compras;

public class Produto {

	private Double valor;
	private String nome;

	public Produto(String nome, Double valor) {
		this.valor = valor;
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
