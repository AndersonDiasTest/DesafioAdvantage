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
		//necessário maximizar pois a tela com o tamanho reduzido tem o comportamento alterado
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
	@Quando("pressiono a tecla Enter para pesquisar")
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
	@Entao("o sistema exibe mensagem {string}")
	public void oSistemaExibeMensagem(String mensagem) {
	    Assert.assertEquals(mensagem, produtosPage.obterMensagemProdutoNaoEncontrado());
	}
	@Quando("clico na categoria Mice")
	public void clicoNaCategoriaMice() {
	    produtosPage.clicaNaCategoriaMice();
	}
	@Quando("clico no filtro Price")
	public void clicoNoFiltroPrice() {
	    produtosPage.clicaAccordionPrice();
	}
	@Quando("seleciono a faixa de preco")
	public void selecionoAFaixaDePreço() {
	    produtosPage.moverSliderPrice(80);	    
	}
	@Quando("clico no filtro Scroller Type")
	public void clicoNoFiltroScrollerType() {
		 produtosPage.clicaAccordionScrollerType();
	}
	@Quando("seleciono o tipo Scroll Ball")
	public void selecionoOTipoScrollBall() {
		 produtosPage.clicaCheckboxScrollBall();
	}
	@Quando("clico no produto")
	public void clicoNoProduto() {
	    produtosPage.clicaProduto("Kensington Orbit 72352 Trackball");
	}
	@Entao("a pagina do produto eh exibida")
	public void aPaginaDoProdutoEhExibida() {
	    Assert.assertEquals("KENSINGTON ORBIT 72352 TRACKBALL", produtosPage.obterTituloProduto());
	}

}
