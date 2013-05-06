package br.edu.unoesc.bibliotecaPessoal.domain;

import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;

public class ProcessadorRegraEmprestimo {

	private List<ProcessoEmprestimo> processos;

	public ProcessadorRegraEmprestimo() {
		this.processos = new ArrayList<>();
		this.processos.add(new MaterialImproprio());
		this.processos.add(new MaterialJaEmprestado());
	}
	
	public void processar(Emprestimo emprestimo){
		for(ProcessoEmprestimo etapa: processos){
			etapa.processar(emprestimo);
		}
	}
	
	public List<ProcessoEmprestimo> getRegras(){
		return processos;
	}
}
