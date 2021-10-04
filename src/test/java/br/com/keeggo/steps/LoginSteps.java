package br.com.keeggo.steps;

import static br.com.keeggo.core.DriverFactory.getDriver;
import static br.com.keeggo.core.DriverFactory.killDriver;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.keeggo.core.Propriedades;
import br.com.keeggo.pages.HomePage;
import br.com.keeggo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps{
	
	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private String usuario;

	@Dado("que eu acesso a aplicacao")
	public void que_eu_acesso_a_aplicacao() {
	    homePage.acessarPaginaInicial();
	}

	@Quando("clico no icone de usuario")
	public void clico_no_icone_de_usuario() {
	    homePage.clicaBotaoUsuario();
	}

	@Quando("no campo Username informo {string}")
	public void no_campo_username_informo(String username) {
	    loginPage.setUsername(username);
	    this.usuario = username;
	}

	@Quando("no campo Password informo {string}")
	public void no_campo_password_informo(String password) {
	    loginPage.setPassword(password);
	}

	@Quando("clico na opcao Sign In")
	public void clico_na_opcao_sign_in() {
	    loginPage.clicaBotaoSignIn();
	}

	@Entao("o sistema exibe o nome do usuario logado no canto superior da tela")
	public void o_sistema_exibe_o_nome_do_usuario_logado_no_canto_superior_da_tela() {
		Assert.assertEquals(usuario, homePage.obterUsuarioLogado());
	}

	@Entao("o sistema mostra a mensagem {string}")
	public void o_sistema_mostra_a_mensagem(String mensagem) {
		Assert.assertEquals(mensagem, loginPage.obterMsgLoginInvalido());
	}
	
	@AfterStep
	public void addScreenshot(Scenario cenario) {
		
		final byte [] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		cenario.attach(screenshot, "image/png", "image");
	}
	
	@After
	public void finaliza() {
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
	
}
