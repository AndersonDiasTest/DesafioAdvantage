package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class ProdutosPage extends BasePage {

	public String obterTituloProduto() {
		esperaElementoSerClicavel(By.xpath("//*[@id='Description']/h1"));
		return obterTexto(By.xpath("//*[@id='Description']/h1"));
	}

	public String obterMensagemProdutoNaoEncontrado() {
		esperaElementoSerClicavel(By.xpath("//label[@class='noProducts roboto-bold ']"));
		return obterTexto(By.xpath("//label[@class='noProducts roboto-bold ']"));
	}

	public void clicaNaCategoriaMice() {
		esperaElementoFicarInvisivel();
		esperaElementoSerClicavel(By.id("miceImg"));
		clicaBotao("miceImg");
	}

	public void clicaAccordionPrice() {
		esperaElementoSerClicavel(By.id("accordionPrice"));
		clicaBotao("accordionPrice");
	}

	public void clicaAccordionScrollerType() {
		esperaElementoSerClicavel(By.id("accordionAttrib0"));
		clicaBotao("accordionAttrib0");
	}

	public void moverSliderPrice(int valorEixoX) {
		esperaElementoSerClicavel(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"));
		moverSlider(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"), valorEixoX);
	}

	public void clicaCheckboxScrollBall() {
		esperaElementoSerClicavel(By.name("scroller_type_0"));
		clicaCheckbox("scroller_type_0");
	}

	public void clicaProduto(String produto) {
		esperaMensagem(By.xpath("//div[@class='cell categoryRight']//p[1]/a"), produto);
		clicaLink(produto);
	}

}
