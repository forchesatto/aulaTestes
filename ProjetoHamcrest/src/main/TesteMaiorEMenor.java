package main;

import compras.CarrinhoDeCompra;
import compras.MaiorEMenor;
import compras.Produto;

public class TesteMaiorEMenor {

	public static void main(String[] args){
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		System.out.println("O menor produto: "+algoritmo.getMenor().getNome());
		System.out.println("O maior produto: "+algoritmo.getMaior().getNome());
	}
}
