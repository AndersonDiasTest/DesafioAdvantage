package br.com.keeggo.pages;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.keeggo.core.BasePage;
import br.com.keeggo.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarPaginaInicial() {
		getDriver().get("https://advantageonlineshopping.com/#/");
	}
	
	public void clicaBotaoUsuario() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("headphonesImg")));
		clicaBotao("menuUser");
	}
	
	public void setUsername (String valor) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		preencheByName("username", valor);
	}
	
	public void setPassword (String valor) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		preencheByName("password", valor);
	}
	
	public void clicaBotaoSignIn() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btnundefined")));
		clicaBotao("sign_in_btnundefined");
	}
	
	public String obterUsuario() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuUserLink']/span")));
		return obterTexto(By.xpath("//a[@id='menuUserLink']/span"));
	}
	
}
