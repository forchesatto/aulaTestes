package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Amigo {

	private String nome;
	private Date data;
	private List<Emprestimo> emprestimos;
	
	public Amigo(){}
	
	public Amigo(String nome, Date data) {
		super();
		this.nome = nome;
		this.data = data;
	}

	public void addEmprestimo(Emprestimo emprestimo){
		if(emprestimos == null){
			emprestimos = new ArrayList<>();
		}
		emprestimos.add(emprestimo);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getIdade() {
		LocalDate dataNas = new LocalDate(getData());
		LocalDate agora = new LocalDate();
		return Years.yearsBetween(dataNas, agora).getYears();
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}
