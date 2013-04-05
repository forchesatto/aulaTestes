package aula01;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenorTest {

	@Test
	public void deveEncontrarOMenorNaOrdemCrescente(){
		Menor menor = new Menor();
		int valores[] = {1,3};
		int min = menor.encontrar(valores);
		
		assertEquals(1, min);
	}
	
	@Test
	public void deveEncontrarOMenorNaOrdemDescrecente(){
		Menor menor = new Menor();
		int valores[] = {3,1};
		int min = menor.encontrar(valores);
		
		assertEquals(1, min);
	}
	
}
