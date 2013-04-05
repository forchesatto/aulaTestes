package compras;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.*;

public class CarrinhoCompraTest {

	@Test
	public void test(){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		Produto produto1 = new Produto("Jogo de pratos", 70.0);
		carrinho.adiciona(produto1);
		Produto produto2 = new Produto("Geladeira", 450.0);
		carrinho.adiciona(produto2);
		Produto produto3 = new Produto("Liquidificador", 250.0); 
		carrinho.adiciona(produto3);
		
		assertEquals(3, carrinho.getProdutos().size());
		
		assertThat(carrinho.getProdutos(), 
				hasItems(produto1, produto2, produto3));
	}
	
	
}
