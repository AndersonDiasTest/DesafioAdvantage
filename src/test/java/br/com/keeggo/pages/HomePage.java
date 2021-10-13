package br.com.keeggo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.com.keeggo.core.BasePage;

public class HomePage extends BasePage {

	public void acessarPaginaInicial() {
		irParaUrl("https://advantageonlineshopping.com/#/");
	}

	public void clicaBotaoUsuario() {
		esperaElementoSerClicavel(By.id("headphonesImg"));
		clicaBotaoById("menuUser");
	}
	
	public String obterUsuarioLogado() {
		esperaElementoSerClicavel(By.xpath("//a[@id='menuUserLink']/span"));
		return obterTexto(By.xpath("//a[@id='menuUserLink']/span"));
	}
	
	public void clicaBotaoPesquisa() {
		esperaElementoFicarInvisivel(By.xpath("//div[@class='PopUp']"));
		esperaElementoSerClicavel(By.id("menuSearch"));
		clicaBotaoById("menuSearch");
	}
	
	public void setCampoPesquisa(String valor) {
		esperaElementoSerClicavel(By.id("autoComplete"));
		preencheById("autoComplete", valor);
	}
	
	public void clicaEnterParaPesquisa() {
		clicaTeclado(By.id("autoComplete"), Keys.ENTER);
	}
	
	public void clicaNaCategoriaMice() {
		esperaElementoFicarInvisivel(By.xpath("//div[@class='PopUp']"));
		esperaElementoSerClicavel(By.id("miceImg"));
		clicaBotaoById("miceImg");
	}
	
	public String obterUrlAtual() {
		return obterUrl();
	}

}
