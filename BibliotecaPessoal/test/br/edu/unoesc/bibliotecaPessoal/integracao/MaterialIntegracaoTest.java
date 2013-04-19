package br.edu.unoesc.bibliotecaPessoal.integracao;

import org.junit.Test;
import static org.junit.Assert.*;

import br.edu.unoesc.bibliotecaPessoal.model.Material;
import br.edu.unoesc.bibliotecaPessoal.model.TipoMaterial;
import br.edu.unoesc.bibliotecaPessoal.service.MaterialService;
import br.edu.unoesc.bibliotecaPessoal.service.ServiceFactory;

public class MaterialIntegracaoTest {

	@Test
	public void deveSalvarNoBancoOMaterial(){
		Material material = 
				new Material("Livro A",2013,TipoMaterial.Livro);
		MaterialService materialService = ServiceFactory
												.getMaterialService();
		materialService.salvar(material);
		assertNotNull(material.getCodigo());
		Material materialBanco = materialService.find(material.getCodigo());
		assertEquals(material, materialBanco);
	}
	
	@Test
	public void deveSalvarNoBancoOMaterialCD(){
		Material material = 
				new Material("CD A",2013,TipoMaterial.CD);
		MaterialService materialService = ServiceFactory
												.getMaterialService();
		materialService.salvar(material);
		assertNotNull(material.getCodigo());
		Material materialBanco = materialService.find(material.getCodigo());
		assertEquals(material, materialBanco);
	}
}
