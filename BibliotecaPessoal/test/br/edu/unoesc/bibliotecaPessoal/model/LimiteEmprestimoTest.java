package br.edu.unoesc.bibliotecaPessoal.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unoesc.bibliotecaPessoal.domain.LimiteEmprestimo;
import br.edu.unoesc.bibliotecaPessoal.domain.LimiteEmprestimoException;
import br.edu.unoesc.bibliotecaPessoal.domain.ProcessoEmprestimo;

public class LimiteEmprestimoTest {

	@Test(expected=LimiteEmprestimoException.class)
	public void naoDeveEmprestarMaisQueDoisSimultaneos(){
		Emprestimo emprestimo1 = new Emprestimo();
		emprestimo1.setStatus(StatusEmprestimo.Ativo);
		Emprestimo emprestimo2 = new Emprestimo();
		emprestimo2.setStatus(StatusEmprestimo.Ativo);
		
		Amigo amigo = new Amigo();
		amigo.addEmprestimo(emprestimo1);
		amigo.addEmprestimo(emprestimo2);
		
		Emprestimo emprestimo3 = new Emprestimo();
		
		emprestimo3.setAmigo(amigo);
		
		ProcessoEmprestimo limiteEmprestimo = new LimiteEmprestimo();
		limiteEmprestimo.processar(emprestimo3);
	}
	
	@Test
	public void deveEmprestarMaisQueUmSimultaneos(){
		Emprestimo emprestimo1 = new Emprestimo();
		emprestimo1.setStatus(StatusEmprestimo.Ativo);
		Emprestimo emprestimo2 = new Emprestimo();
		emprestimo2.setStatus(StatusEmprestimo.Ativo);
		
		Amigo amigo = new Amigo();
		amigo.addEmprestimo(emprestimo1);
		
		Emprestimo emprestimo3 = new Emprestimo();
		
		emprestimo3.setAmigo(amigo);
		
		ProcessoEmprestimo limiteEmprestimo = new LimiteEmprestimo();
		limiteEmprestimo.processar(emprestimo3);
		amigo.addEmprestimo(emprestimo3);
		
		assertEquals(2, amigo.getEmprestimos().size());
		
	}
}
