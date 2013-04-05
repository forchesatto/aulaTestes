package compras;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaMaiorEMenor {

	@Test
	public void ordemDecrescente(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		assertEquals("Geladeira", algoritmo.getMaior().getNome());

	}
	
	@Test
	public void apenasUmProduto(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		assertEquals("Geladeira", algoritmo.getMenor().getNome());
		assertEquals("Geladeira", algoritmo.getMaior().getNome());

	}
	
	@Test
	public void ordemCrescente(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
	@Test
	public void ordemAleatoria(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
	@Test
	public void deveAdicionar3Produtos(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		
		assertEquals(3, carrinho.getProdutos().size());
	}

	
	
	


}
