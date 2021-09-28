package br.com.keeggo.steps;

import static br.com.keeggo.core.DriverFactory.getDriver;

import org.junit.Assert;

import br.com.keeggo.pages.HomePage;
import br.com.keeggo.pages.ProdutosPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ConsultarProdutoSteps {

	private HomePage homePage = new HomePage();
	private ProdutosPage produtosPage = new ProdutosPage();
	
	@Before
	public void inicializa() {
		getDriver().manage().window().maximize();
	}
	
	@Quando("clico no icone de Pesquisa")
	public void clicoNoIconeDePesquisa() {
	    homePage.clicaBotaoPesquisa();
	}
	@Quando("no campo de pesquisa preencho {string}")
	public void noCampoDePesquisaPreencho(String produto) {
	    homePage.setCampoPesquisa(produto);
	}
	@Quando("clico na opcao Pesquisar")
	public void clicoNaOpcaoPesquisar() {
	    homePage.clicaEnterParaPesquisa();
	}
	@Quando("clico em um dos produtos da lista")
	public void clicoEmUmDosProdutosDaLista() throws InterruptedException {
		homePage.clicaProduto("ELITEPAD");
	}
	@Entao("o produto eh exibido")
	public void oProdutoEhExibido() {
	    Assert.assertEquals("HP ELITEPAD 1000 G2 TABLET", produtosPage.obterTituloProduto());
	}
}
