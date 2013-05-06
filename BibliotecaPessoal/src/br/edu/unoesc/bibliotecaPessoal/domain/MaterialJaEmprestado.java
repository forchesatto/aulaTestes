package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Emprestimo;
import br.edu.unoesc.bibliotecaPessoal.model.StatusMaterial;

public class MaterialJaEmprestado implements ProcessoEmprestimo {

	@Override
	public void processar(Emprestimo emprestimo) {
		if(emprestimo.getMaterial().getStatus().equals(StatusMaterial.Emprestado)){
			throw new MaterialJaEmprestadoException("Material Já emprestado");
		}
	}

}
