package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	public void preencheByName(String campo, String valor) {
		getDriver().findElement(By.name(campo)).clear();
		getDriver().findElement(By.name(campo)).sendKeys(valor);
	}
	
	public void clicaBotao(String campo) {
		getDriver().findElement(By.id(campo)).click();
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
}
