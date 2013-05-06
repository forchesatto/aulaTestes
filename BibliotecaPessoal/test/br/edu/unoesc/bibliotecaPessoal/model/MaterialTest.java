package br.edu.unoesc.bibliotecaPessoal.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unoesc.bibliotecaPessoal.service.MaterialService;
import br.edu.unoesc.bibliotecaPessoal.service.MaterialServiceFind;

@RunWith(MockitoJUnitRunner.class)
public class MaterialTest {

	@Mock
	private MaterialService materialService;
	
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
	
	@Test
	public void deveListarMateriaisDisponivel(){
		Material material1 = new Material();
		material1.setStatus(StatusMaterial.Disponivel);
		Material material2 = new Material();
		material2.setStatus(StatusMaterial.Indisponivel);
		Material material3 = new Material();
		material3.setStatus(StatusMaterial.Disponivel);
		Material material4 = new Material();
		material4.setStatus(StatusMaterial.Indisponivel);
		
		List<Material> materiais = Arrays.asList(material1, material2, material3, material4);
		
		
		Mockito.when(materialService.findAll()).thenReturn(materiais);
		
		MaterialServiceFind materialServiceFind = new MaterialServiceFind(materialService);
		
		List<Material> findAllDisponivel = materialServiceFind.findAllDisponivel();
		
		assertNotNull(findAllDisponivel);
		assertEquals(2, findAllDisponivel.size());
		assertEquals(material1, findAllDisponivel.get(0));
		assertEquals(material2, findAllDisponivel.get(1));
	}
}
