package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;

public class BibliotecaImpl implements Biblioteca {

	private ProcessadorRegraEmprestimo processadorRegraEmprestimo;
	
	public BibliotecaImpl(ProcessadorRegraEmprestimo processadorRegraEmprestimo){
		this.processadorRegraEmprestimo = processadorRegraEmprestimo;
	}
	
	@Override
	public void emprestar(Emprestimo emprestimo){
		processadorRegraEmprestimo.processar(emprestimo);
	}

}
