package aula01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class MaiorTest {

	@Test
	public void deveEncontrarOMaiorNaOrdemCrescente(){
		Maior maior = new Maior();
		int valores[] = {1,3};
		int max = maior.encontrar(valores);
		
		assertEquals(3, max);//Verifica se max é igual a 1
	}
	
	@Test
	public void deveEncontrarOMaiorNaOrdemDescrecente(){
		Maior maior = new Maior();
		int valores[] = {3,1};
		int max = maior.encontrar(valores);
		
		assertEquals(3, max);//Verifica se max é igual a 1
		
		assertThat(3, is(3));
	}
	
}
