package br.edu.unoesc.bibliotecaPessoal.model;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;

public class AmigoTest {

	@Test
	public void deveTer10Anos(){
		LocalDate data = new LocalDate();
		data = data.minusYears(10);
		Amigo amigo = new Amigo();
		amigo.setData(data.toDate());
		assertThat(amigo.getIdade(), is(10));
	}
}
