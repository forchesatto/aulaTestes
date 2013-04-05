package compras;

public class MaiorEMenor {

	private Produto maior;
	private Produto menor;
	
	public void encontra(CarrinhoDeCompra carrinho){
		for (Produto produto : carrinho.getProdutos()) {
			if(menor == null || produto.getValor() < menor.getValor()){
				menor = produto;
			}
			if(maior == null || produto.getValor() > maior.getValor()){
				maior = produto;
			}
		}
	}
	
	public Produto getMaior() {
		return maior;
	}
	public Produto getMenor() {
		return menor;
	}
	
}
