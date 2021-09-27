package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void acessarPaginaInicial() {
		getDriver().get("https://advantageonlineshopping.com/#/");
	}

	public void clicaBotaoUsuario() {
		esperaElementoSerClicavel(By.id("headphonesImg"));
		clicaBotao("menuUser");
	}

	public void preencheByName(String campo, String valor) {
		getDriver().findElement(By.name(campo)).clear();
		getDriver().findElement(By.name(campo)).sendKeys(valor);
	}

	public void clicaBotao(String campo) {
		getDriver().findElement(By.id(campo)).click();
	}

	public void clicaLink(String campo) {
		getDriver().findElement(By.linkText(campo)).click();
	}

	public void clicaCheckbox(String campo) {
		getDriver().findElement(By.name(campo)).click();
	}

	public void selecionaOpcaoCombo(String campo, String valor) {
		WebElement elemento = getDriver().findElement(By.name(campo));
		Select combo = new Select(elemento);
//		combo.selectByIndex(1);
		List<WebElement> opcoes = combo.getOptions();
		for (WebElement webElement : opcoes) {
			System.out.println(webElement.getAttribute("value"));
		}
	}

	// ------------recuperar valores--------------------//

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public boolean checkboxEstaSelecionado(String campo) {
		return getDriver().findElement(By.name(campo)).isSelected();
	}

	// -------------------wait-----------------------//

	public void esperaElementoSerClicavel(By by) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void esperaMensagem(By by, String mensagem) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.textToBe(by, mensagem));
	}
}
