package br.edu.unoesc.bibliotecaPessoal.domain;

import br.edu.unoesc.bibliotecaPessoal.model.Amigo;
import br.edu.unoesc.bibliotecaPessoal.model.Material;

public interface Biblioteca {

	void emprestar(Material material, Amigo amigo) 
			throws MaterialJaEmprestadoException, MaterialImproprioException;

}
