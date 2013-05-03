package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Amigo;
import br.edu.unoesc.bibliotecaPessoal.model.Material;
import br.edu.unoesc.bibliotecaPessoal.model.StatusMaterial;

public class BibliotecaImpl implements Biblioteca {

	@Override
	public void emprestar(Material material, Amigo amigo)
			throws MaterialJaEmprestadoException,
			MaterialImproprioException {
		if(material.getStatus().equals(StatusMaterial.Emprestado)){
			throw new MaterialJaEmprestadoException("Material Já emprestado");
		}
		if(amigo.getIdade() < 
				material.getClassificacaoIndicativa().getIdadeMaxima()){
			throw new MaterialImproprioException("Material improprio");
		}
	}

}
