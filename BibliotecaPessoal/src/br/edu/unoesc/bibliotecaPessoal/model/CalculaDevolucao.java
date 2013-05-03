package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;

import org.joda.time.LocalDate;

public class CalculaDevolucao {

	private Material material;
	private Date dataEmprestimo;

	public CalculaDevolucao(Date dataEmprestimo, Material material) {
		this.material = material;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date data(){
		LocalDate dataDevolucao = new LocalDate(dataEmprestimo);
		dataDevolucao = dataDevolucao
				.plusDays(material.getTipoMaterial()
						.getQuantidadeDiasEmprestimo());
		return dataDevolucao.toDate();
	}
	
}
