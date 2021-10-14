package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	public void irParaUrl(String url) {
		getDriver().get(url);
	}

	public void preencheByName(String campo, String valor) {
		getDriver().findElement(By.name(campo)).clear();
		getDriver().findElement(By.name(campo)).sendKeys(valor);
	}
	
	public void preencheById(String campo, String valor) {
		getDriver().findElement(By.id(campo)).clear();
		getDriver().findElement(By.id(campo)).sendKeys(valor);
	}

	public void clicaBotaoById(String campo) {
		clicaBotao(By.id(campo));
	}
	
	public void clicaBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicaLink(String campo) {
		getDriver().findElement(By.linkText(campo)).click();
	}

	public void clicaCheckboxByName(String campo) {
		getDriver().findElement(By.name(campo)).click();
	}

	public void selecionaOpcaoCombo(String campo, String valor) {
		WebElement elemento = getDriver().findElement(By.name(campo));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	
	public void clicaTeclado(By by, Keys key) {
		getDriver().findElement(by).sendKeys(key);
	}
	
	public void removeFocoCampo(String idCampo) {
		getDriver().findElement(By.id(idCampo)).click();
	}
	
	public void moverSlider(By by, int valorEixoX) {
		Actions acao = new Actions(getDriver());
		WebElement slider = getDriver().findElement(by);
		acao.dragAndDropBy(slider, valorEixoX, 0).perform();
	}

	// ------------recuperar valores--------------------//

	public String obterUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public boolean checkboxEstaSelecionado(String nameCampo) {
		return getDriver().findElement(By.name(nameCampo)).isSelected();
	}
	
	public String obterMensagem(String nameCampo) {
		return getDriver()
				.findElement(By.xpath("//*[@name='" + nameCampo + "']/../label[@class='invalid']")).getText();
	}
	
	public boolean botaoEstaHabilitado(String idCampo) {
		return getDriver().findElement(By.id(idCampo)).isEnabled();
	}

	// -------------------wait-----------------------//

	public void esperaElementoSerClicavel(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void esperaMensagemSer(By by, String mensagem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.textToBe(by, mensagem));
	}
	
	public void esperaElementoFicarInvisivel(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(by));
	}
}
