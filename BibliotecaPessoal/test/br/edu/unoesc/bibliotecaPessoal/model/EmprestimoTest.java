package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unoesc.bibliotecaPessoal.domain.Biblioteca;
import br.edu.unoesc.bibliotecaPessoal.domain.BibliotecaImpl;
import br.edu.unoesc.bibliotecaPessoal.domain.LimiteEmprestimo;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialImproprio;
import br.edu.unoesc.bibliotecaPessoal.domain.MaterialJaEmprestado;
import br.edu.unoesc.bibliotecaPessoal.domain.ProcessadorRegraEmprestimo;
import br.edu.unoesc.bibliotecaPessoal.domain.ProcessoEmprestimo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class EmprestimoTest {

	@Mock
	private ProcessadorRegraEmprestimo processador;
	
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
	
	@Test
	public void deveProcessarTodasAsRegras(){
		ProcessadorRegraEmprestimo processador = 
				new ProcessadorRegraEmprestimo();
		List<ProcessoEmprestimo> regrasProcessadas = 
				processador.getRegras();
		assertEquals(3, regrasProcessadas.size());
		assertEquals(MaterialImproprio.class, 
				regrasProcessadas.get(0).getClass());
		assertEquals(MaterialJaEmprestado.class, 
				regrasProcessadas.get(1).getClass());
		assertEquals(LimiteEmprestimo.class, 
				regrasProcessadas.get(2).getClass());
	}
	
	@Test
	public void deveExecutarProcessadoDeRegras(){
		Biblioteca biblioteca = new BibliotecaImpl(processador);
		
		Emprestimo emprestimo = new Emprestimo();
		
		biblioteca.emprestar(emprestimo);
		
		Mockito.verify(processador).processar(emprestimo);
	}
	
}
