package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {



	public void preencheByName(String campo, String valor) {
		getDriver().findElement(By.name(campo)).clear();
		getDriver().findElement(By.name(campo)).sendKeys(valor);
	}
	
	public void preencheById(String campo, String valor) {
		getDriver().findElement(By.id(campo)).clear();
		getDriver().findElement(By.id(campo)).sendKeys(valor);
	}

	public void clicaBotao(String campo) {
		clicaBotao(By.id(campo));
	}
	
	public void clicaBotao(By by) {
		getDriver().findElement(by).click();
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
		combo.selectByVisibleText(valor);
	}
	
	public void clicaTeclado(Keys key) {
		getDriver().findElement(By.id("autoComplete")).sendKeys(key);
	}

	// ------------recuperar valores--------------------//

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public boolean checkboxEstaSelecionado(String campo) {
		return getDriver().findElement(By.name(campo)).isSelected();
	}
	
	public String obterMensagem(String campo) {
		return getDriver().findElement(By.xpath("//*[@name='" + campo + "']/../label[@class='invalid']")).getText();
	}
	
	public boolean botaoEstaHabilitado(String campo) {
		return getDriver().findElement(By.id(campo)).isEnabled();
	}

	// -------------------wait-----------------------//

	public void esperaElementoSerClicavel(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void esperaMensagem(By by, String mensagem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(by, mensagem));
	}
	
	public void esperaElementoFicarInvisivel() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='PopUp']")));
	}
}
