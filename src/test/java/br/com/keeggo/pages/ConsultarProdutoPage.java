package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class ConsultarProdutoPage extends BasePage {

	public void clicaBotaoPesquisa() {
		esperaElementoSerClicavel(By.id("menuSearch"));
		clicaBotao("menuSearch");
	}
	
	public void setCampoPesquisa(String valor) {

	}
}
