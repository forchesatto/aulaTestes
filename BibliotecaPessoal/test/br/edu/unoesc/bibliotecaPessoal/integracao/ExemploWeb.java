package br.edu.unoesc.bibliotecaPessoal.integracao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExemploWeb {

	@Test
	public void testWebDriver(){
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com.br/");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Unoesc");
		
		campoDeTexto.submit();
		
		boolean resultadoUnoesc = driver.getPageSource().contains("Unoesc");
		
		assertTrue(resultadoUnoesc);
		
		driver.close();
	}
}
