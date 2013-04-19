package br.edu.unoesc.bibliotecaPessoal.service;

public class ServiceFactory {

	public static MaterialService getMaterialService() {
		return new MaterialService();
	}

}
