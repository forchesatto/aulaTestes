package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;

public class Emprestimo {

	private Date dataEmprestimo;
	private Amigo amigo;
	private Material material;
	private Date dataPrevistaDevolucao;
	
	public Emprestimo(){
		
	}
	
	public Emprestimo(Date dataEmprestimo, Amigo amigo, Material material,
			Date dataPrevistaDevolucao) {
		this.dataEmprestimo = dataEmprestimo;
		this.amigo = amigo;
		this.material = material;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Amigo getAmigo() {
		return amigo;
	}
	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	
	
}
