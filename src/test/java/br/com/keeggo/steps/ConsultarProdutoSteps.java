package br.com.keeggo.steps;

import br.com.keeggo.pages.ConsultarProdutoPage;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ConsultarProdutoSteps {

	private ConsultarProdutoPage consultarPage = new ConsultarProdutoPage();
	
	@Quando("clico no icone de Pesquisa")
	public void clicoNoIconeDePesquisa() {
	    consultarPage.clicaBotaoPesquisa();
	}
	@Quando("no campo de pesquisa preencho {string}")
	public void noCampoDePesquisaPreencho(String produto) {
	    
	}
	@Quando("clico na opcao Pesquisar")
	public void clicoNaOpcaoPesquisar() {
	    
	}
	@Quando("clico em um dos produtos da lista")
	public void clicoEmUmDosProdutosDaLista() {
	    
	}
	@Entao("o produto eh exibido")
	public void oProdutoEhExibido() {
	    
	}
}
