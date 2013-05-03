package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Amigo {

	private String nome;
	private Date data;
	
	public Amigo(){}
	
	public Amigo(String nome, Date data) {
		super();
		this.nome = nome;
		this.data = data;
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
	
	
}
