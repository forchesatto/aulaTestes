package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;
import br.edu.unoesc.bibliotecaPessoal.model.StatusEmprestimo;
import br.edu.unoesc.bibliotecaPessoal.model.StatusMaterial;

public class BibliotecaImpl implements Biblioteca {

	private ProcessadorRegraEmprestimo processadorRegraEmprestimo;
	
	public BibliotecaImpl(ProcessadorRegraEmprestimo processadorRegraEmprestimo){
		this.processadorRegraEmprestimo = processadorRegraEmprestimo;
	}
	
	@Override
	public void emprestar(Emprestimo emprestimo){
		processadorRegraEmprestimo.processar(emprestimo);
		emprestimo.setStatus(StatusEmprestimo.Ativo);
		if(emprestimo.getMaterial() != null){
			emprestimo.getMaterial().setStatus(StatusMaterial.Emprestado);
		}
	}

}
