package br.com.keeggo.pages;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.com.keeggo.core.BasePage;

public class HomePage extends BasePage {

	public void acessarPaginaInicial() {
		getDriver().get("https://advantageonlineshopping.com/#/");
	}

	public void clicaBotaoUsuario() {
		esperaElementoSerClicavel(By.id("headphonesImg"));
		clicaBotao("menuUser");
	}
	
	public void clicaBotaoPesquisa() {
		esperaElementoFicarInvisivel();
		esperaElementoSerClicavel(By.id("menuSearch"));
		clicaBotao("menuSearch");
	}
	
	public void setCampoPesquisa(String valor) {
		preencheById("autoComplete", valor);
	}
	
	public void clicaEnterParaPesquisa() {
		clicaTeclado(Keys.ENTER);
	}

	public void clicaProduto(String produto) throws InterruptedException {
//		esperaElementoSerClicavel(By.xpath("//p[contains(text(),'"+ produto +"')]"));
//		esperaMensagem(By.xpath("//p[contains(text(),'"+ produto +"')]"), "HP ELITEPAD 1000 G2 TABLET");
		Thread.sleep(5000);
		clicaBotao(By.xpath("//p[contains(text(),'"+ produto +"')]"));
	}
	
	public String obterUrlAtual() {
		return getDriver().getCurrentUrl();
	}

}
