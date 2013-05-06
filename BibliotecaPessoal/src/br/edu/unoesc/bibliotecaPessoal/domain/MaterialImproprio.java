package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;

public class MaterialImproprio implements ProcessoEmprestimo {

	@Override
	public void processar(Emprestimo emprestimo) {
		if(emprestimo.getAmigo().getIdade() < 
				emprestimo.getMaterial().getClassificacaoIndicativa().getIdadeMaxima()){
			throw new MaterialImproprioException("Material improprio");
		}
	}

}
