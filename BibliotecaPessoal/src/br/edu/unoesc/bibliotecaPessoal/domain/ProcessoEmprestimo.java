package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;

public interface ProcessoEmprestimo {

	void processar(Emprestimo emprestimo);
}
