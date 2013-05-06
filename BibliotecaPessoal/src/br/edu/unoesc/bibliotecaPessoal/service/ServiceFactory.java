package br.edu.unoesc.bibliotecaPessoal.service;

import br.edu.unoesc.bibliotecaPessoal.domain.Biblioteca;
import br.edu.unoesc.bibliotecaPessoal.domain.BibliotecaImpl;
import br.edu.unoesc.bibliotecaPessoal.domain.ProcessadorRegraEmprestimo;

public class ServiceFactory {

	public static MaterialService getMaterialService() {
		return new MaterialService();
	}
	
	public static Biblioteca getBiblioteca(){
		return new BibliotecaImpl(new ProcessadorRegraEmprestimo());
	}

}
