package br.edu.unoesc.bibliotecaPessoal.model;

import org.joda.time.LocalDate;
import org.junit.Test;

import br.edu.unoesc.bibliotecaPessoal.domain.MaterialImproprio;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialImproprioException;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialJaEmprestadoException;
import br.edu.unoesc.bibliotecaPessoal.domain.ProcessoEmprestimo;

public class MaterialImproprioTest {

	@Test(expected = MaterialImproprioException.class)
	public void naoPossoEmprestarParaMenorMaterialImproprio() 
			throws MaterialJaEmprestadoException, 
			MaterialImproprioException{
		LocalDate agora = new LocalDate();
		LocalDate dataNascimento = agora.minusYears(10);
		Amigo amigo = new Amigo();
		amigo.setData(dataNascimento.toDate());
		Material material = new Material();
		material.setClassificacaoIndicativa(ClassificacaoIndicativa.Maior);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setAmigo(amigo);
		emprestimo.setMaterial(material);
		
		ProcessoEmprestimo materialImproprio = new MaterialImproprio();
		
		materialImproprio.processar(emprestimo);
		
	}
	
	@Test
	public void possoEmprestarParaMaior() 
			throws MaterialJaEmprestadoException, 
			MaterialImproprioException{
		LocalDate agora = new LocalDate();
		LocalDate dataNascimento = agora.minusYears(18);
		Amigo amigo = new Amigo();
		amigo.setData(dataNascimento.toDate());
		Material material = new Material();
		material.setClassificacaoIndicativa(ClassificacaoIndicativa.Maior);

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setAmigo(amigo);
		emprestimo.setMaterial(material);
		
		ProcessoEmprestimo materialImproprio = new MaterialImproprio();
		
		materialImproprio.processar(emprestimo);
	}
	

}
