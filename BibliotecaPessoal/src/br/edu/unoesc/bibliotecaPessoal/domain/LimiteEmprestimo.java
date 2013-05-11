package br.edu.unoesc.bibliotecaPessoal.domain;

import java.util.List;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;
import br.edu.unoesc.bibliotecaPessoal.model.StatusEmprestimo;

public class LimiteEmprestimo implements ProcessoEmprestimo {

	@Override
	public void processar(Emprestimo emprestimo) {
		List<Emprestimo> emprestimos = emprestimo.getAmigo().getEmprestimos();
		int count = 0;
		for (Emprestimo emp : emprestimos) {
			if(emp.getStatus().equals(StatusEmprestimo.Ativo)){
				count++;
			}
			if(count == 2){
				throw new LimiteEmprestimoException("Limite de emprestimo excedido");
			}
		}
	}

}
