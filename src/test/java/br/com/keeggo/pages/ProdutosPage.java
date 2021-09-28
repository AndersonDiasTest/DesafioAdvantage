package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class ProdutosPage extends BasePage {

	public String obterTituloProduto() {
		esperaElementoSerClicavel(By.xpath("//*[@id='Description']/h1"));
		return obterTexto(By.xpath("//*[@id='Description']/h1"));
	}
}
