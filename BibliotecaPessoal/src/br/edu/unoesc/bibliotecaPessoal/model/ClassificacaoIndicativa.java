package br.edu.unoesc.bibliotecaPessoal.model;

public enum ClassificacaoIndicativa {

	Maior(18), Menor(17);
	
	private Integer idadeMaxima;
	
	ClassificacaoIndicativa(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}
	
	public Integer getIdadeMaxima(){
		return this.idadeMaxima;
	}
}
