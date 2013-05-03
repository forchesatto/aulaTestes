package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import br.edu.unoesc.bibliotecaPessoal.domain.Biblioteca;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialImproprioException;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialJaEmprestadoException;
import br.edu.unoesc.bibliotecaPessoal.service.ServiceFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmprestimoTest {

	@Test
	public void deveCriarUmEmprestimo(){
		LocalDate dataNascimento = new LocalDate(1980, 9, 27);
		Amigo amigo = new Amigo("André", dataNascimento.toDate());
		Material material = new Material("Livro A", 2012, TipoMaterial.Livro);
		Date dataEmprestimo = new Date();
		Date dataDevolucaoPrevista = new CalculaDevolucao(dataEmprestimo, material).data();
		Emprestimo emprestimo = new Emprestimo(dataEmprestimo, 
						amigo, material, dataDevolucaoPrevista);
		assertNotNull(emprestimo);
		assertEquals(amigo, emprestimo.getAmigo());
		assertEquals(material, emprestimo.getMaterial());
		assertEquals(dataDevolucaoPrevista, emprestimo.getDataPrevistaDevolucao());
		assertEquals(dataEmprestimo,emprestimo.getDataEmprestimo());
	}
	
	@Test(expected=MaterialJaEmprestadoException.class)
	public void naoPossoEmprestarMaterialJaEmprestado() 
			throws MaterialJaEmprestadoException, 
			MaterialImproprioException{
		Material material = new Material();
		Amigo amigo = new Amigo();
		material.setStatus(StatusMaterial.Emprestado);
		Biblioteca biblioteca = ServiceFactory.getBiblioteca();
		biblioteca.emprestar(material, amigo);
	}
	
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
		Biblioteca biblioteca = ServiceFactory.getBiblioteca();
		biblioteca.emprestar(material, amigo);
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
		Biblioteca biblioteca = ServiceFactory.getBiblioteca();
		biblioteca.emprestar(material, amigo);
	}
	
	
}
