package br.edu.unoesc.bibliotecaPessoal.model;

import org.junit.Test;

import br.edu.unoesc.bibliotecaPessoal.domain.MaterialImproprioException;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialJaEmprestado;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialJaEmprestadoException;

public class MaterialEmprestadoTest {

	@Test(expected=MaterialJaEmprestadoException.class)
	public void naoPossoEmprestarMaterialJaEmprestado() 
			throws MaterialJaEmprestadoException, 
			MaterialImproprioException{
		Material material = new Material();
		material.setStatus(StatusMaterial.Emprestado);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setMaterial(material);
		
		MaterialJaEmprestado processo = new MaterialJaEmprestado();
		processo.processar(emprestimo);
		
	}
	
	@Test
	public void possoEmprestarMaterial() 
			throws MaterialJaEmprestadoException, 
			MaterialImproprioException{
		Material material = new Material();
		material.setStatus(StatusMaterial.Disponivel);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setMaterial(material);
		
		MaterialJaEmprestado processo = new MaterialJaEmprestado();
		processo.processar(emprestimo);
		
	}
}
