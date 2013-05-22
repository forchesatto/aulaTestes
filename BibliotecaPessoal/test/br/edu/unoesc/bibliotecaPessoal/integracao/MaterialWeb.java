package br.edu.unoesc.bibliotecaPessoal.integracao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MaterialWeb {

	private static WebDriver driver;
	
	@BeforeClass
	public static void before(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void deveAcessarFormularioMaterial(){
		
		driver.get("http://localhost:8080/BibliotecaPessoal/material");
		
		WebElement codigo = driver.findElement(By.name("material.codigo"));
		WebElement nome = driver.findElement(By.name("material.nome"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		assertNotNull(codigo);
		assertNotNull(nome);
		assertNotNull(botaoSalvar);
	}
	@Test
	public void deveSalvarNoBancoERedirecionalParaSalvoComSucesso(){
		driver.get("http://localhost:8080/BibliotecaPessoal/material");
		
		WebElement nome = driver.findElement(By.name("material.nome"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		
		nome.sendKeys("Livro TDD");
		
		botaoSalvar.click();
		
		boolean salvo = driver.getPageSource()
				.contains("Sucesso");
		
		assertTrue(salvo);
	}
	
	@AfterClass
	public static void after(){
		driver.close();
	}
}
