package br.edu.unoesc.bibliotecaPessoal.model;

public enum TipoMaterial {
	Livro(10),
	CD(2),
	DVD(2),
	Revista(5);
	
	TipoMaterial(Integer quantidadeDiasEmprestimo){
		this.quantidadeDiasEmprestimo = quantidadeDiasEmprestimo;
	}
	
	private Integer quantidadeDiasEmprestimo;

	public Integer getQuantidadeDiasEmprestimo() {
		return quantidadeDiasEmprestimo;
	}
}
