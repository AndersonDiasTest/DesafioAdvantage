package br.com.keeggo.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.keeggo.core.Utils;
import br.com.keeggo.pages.CadastroPage;
import br.com.keeggo.pages.HomePage;
import br.com.keeggo.pages.LoginPage;
import io.cucumber.java.pt. Entao;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
	
	private CadastroPage cadastroPage = new CadastroPage();
	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private Utils util = new Utils();
	private String usuario;
	
	@Quando("clico na opcao Create New Account")
	public void clicoNaOpcaoCreateNewAccount() {
		loginPage.clicaBotaoNovaConta();
	}
	@Quando("no campo Username preencho {string}")
	public void noCampoUsernamePreencho(String username) throws IOException {
		username = util.recuperaCelulaString(0);
		this.usuario = username;
	    cadastroPage.setUsername(username);
	}
	@Quando("no campo Email preencho {string}")
	public void noCampoEmailPreencho(String email) throws IOException {
		email = util.recuperaCelulaString(1);
	    cadastroPage.setEmail(email);
	}
	@Quando("no campo Password preencho {string}")
	public void noCampoPasswordPreencho(String password) throws IOException {
		password = util.recuperaCelulaString(2);
	    cadastroPage.setPassword(password);
	}
	@Quando("no campo Confirm Password preencho {string}")
	public void noCampoConfirmPasswordPreencho(String confirmPassword) throws IOException {
		confirmPassword = util.recuperaCelulaString(3);
		cadastroPage.setConfirmPassword(confirmPassword);
	}
	@Quando("no campo First Name preencho {string}")
	public void noCampoFirstNamePreencho(String firstName) throws IOException {
		firstName = util.recuperaCelulaString(4);
	    cadastroPage.setFirstName(firstName);
	}
	@Quando("no campo Last Name preencho {string}")
	public void noCampoLastNamePreencho(String lastName) throws IOException {
		lastName = util.recuperaCelulaString(5);
		cadastroPage.setLastName(lastName);
	}
	@Quando("no campo Phone Number preencho {string}")
	public void noCampoPhoneNumberPreencho(String phoneNumber) throws IOException {
		phoneNumber = util.recuperaCelulaNumerica(6);
		cadastroPage.setPhoneNumber(phoneNumber);
	}
	@Quando("no campo Country preencho {string}")
	public void noCampoCountryPreencho(String country) throws InterruptedException, IOException {
		country = util.recuperaCelulaString(7);
		cadastroPage.setCountry(country);
	}
	@Quando("no campo City preencho {string}")
	public void noCampoCityPreencho(String city) throws IOException {
		city = util.recuperaCelulaString(8);
		cadastroPage.setCity(city);
	}
	@Quando("no campo Address preencho {string}")
	public void noCampoAddressPreencho(String address) throws IOException {
		address = util.recuperaCelulaString(9);
		cadastroPage.setAddress(address);
	}
	@Quando("no campo State Province Region preencho {string}")
	public void noCampoStateProvinceRegionPreencho(String stateProvinceRegion) throws IOException {
		stateProvinceRegion = util.recuperaCelulaString(10);
		cadastroPage.setStateProvinceRegion(stateProvinceRegion);
	}
	@Quando("no campo Postal Code preencho {string}")
	public void noCampoPostalCodePreencho(String postalCode) throws IOException {
		postalCode = util.recuperaCelulaNumerica(11);
		cadastroPage.setPostalCode(postalCode);
	}
	@Quando("verifico que a opcao Receber ofertas esta marcada")
	public void verificoQueAOpcaoReceberOfertasEstaMarcada() throws IOException {
		if (util.recuperaCelulaBoolean(12)) {
			Assert.assertTrue(cadastroPage.permitePromocoesEstaSelecionado());
		} else {
			cadastroPage.clicaCheckboxEmailsPromocionais();
		}
	}
	@Quando("clico na opcao Aceitar termos")
	public void clicoNaOpcaoAceitarTermos() throws IOException {
		if (util.recuperaCelulaBoolean(13)) {
			cadastroPage.clicaCheckboxTermos();
		}	    
	}
	@Quando("clico na opcao Register")
	public void clicoNaOpcaoRegister() {
	    cadastroPage.clicaBotaoRegister();
	}
	@Entao("o sistema exibe a mensagem {string} abaixo do campo {string}")
	public void oSistemaExibeAMensagem(String mensagem, String campo) {
	    Assert.assertEquals(mensagem, cadastroPage.obterMsgCampoObrigatorio(campo));
	}
	@Entao("a opcao Register fica desabilitado")
	public void aOpcaoRegisterFicaDesabilitado() {
	    Assert.assertFalse(cadastroPage.botaoRegisterEstaHabilitado());
	}
	@Entao("o sistema exibe a mensagem {string}")
	public void oSistemaExibeAMensagem(String mensagem) {
		Assert.assertEquals(mensagem, cadastroPage.obterMsgContaJaExistente());
	}
	@Entao("o sistema realiza o login do usuario e exibe o nome no canto superior da tela")
	public void oSistemaRealizaOLoginDoUsuarioEExibeONomeNoCantoSuperiorDaTela() {
		Assert.assertEquals(usuario, homePage.obterUsuarioLogado());
	}
	@Entao("direciona para a home page")
	public void direcionaParaAHomePage() {
	    Assert.assertEquals("https://advantageonlineshopping.com/#/", homePage.obterUrlAtual());
	}

}
