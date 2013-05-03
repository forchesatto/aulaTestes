package br.edu.unoesc.bibliotecaPessoal.model;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculaDevolucaoTest {

	@Test
	public void deveSomar10DiasParaLivro(){
		Material material = new Material();
		material.setTipoMaterial(TipoMaterial.Livro);
		LocalDate dataEmprestimo = new LocalDate(2013, 3, 19);
		CalculaDevolucao calcula = new CalculaDevolucao(
				dataEmprestimo.toDate(),material);
		Date dataDevolucao = calcula.data();
		Date dataEsperada = dataEmprestimo.plusDays(10).toDate();
		assertEquals(dataEsperada, dataDevolucao);
	}
}
