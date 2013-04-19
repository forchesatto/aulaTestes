package br.edu.unoesc.bibliotecaPessoal.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaterialTest {

	@Test
	public void deveCriarUmMaterialComValores(){
		Material material = 
				new Material("Livro sobre Testes", 
						2002, TipoMaterial.Livro);
		assertEquals("Livro sobre Testes", material.getNome());
		assertEquals(Integer.valueOf(2002), material.getAnoEdicao());
		assertEquals(TipoMaterial.Livro, material.getTipoMaterial());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeCriarUmMaterialComNomeNull(){
		new Material(null,2002,TipoMaterial.CD);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeCriarUmMaterialComTipoNull(){
		new Material("Teste",2002,null);
	}
}
