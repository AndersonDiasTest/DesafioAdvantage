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
		username = util.recuperaCelulaString("Username");
		this.usuario = username;
	    cadastroPage.setUsername(username);
	}
	@Quando("no campo Email preencho {string}")
	public void noCampoEmailPreencho(String email) throws IOException {
		email = util.recuperaCelulaString("Email");
	    cadastroPage.setEmail(email);
	}
	@Quando("no campo Password preencho {string}")
	public void noCampoPasswordPreencho(String password) throws IOException {
		password = util.recuperaCelulaString("Password");
	    cadastroPage.setPassword(password);
	}
	@Quando("no campo Confirm Password preencho {string}")
	public void noCampoConfirmPasswordPreencho(String confirmPassword) throws IOException {
		confirmPassword = util.recuperaCelulaString("Confirm Password");
		cadastroPage.setConfirmPassword(confirmPassword);
	}
	@Quando("no campo First Name preencho {string}")
	public void noCampoFirstNamePreencho(String firstName) throws IOException {
		firstName = util.recuperaCelulaString("First Name");
	    cadastroPage.setFirstName(firstName);
	}
	@Quando("no campo Last Name preencho {string}")
	public void noCampoLastNamePreencho(String lastName) throws IOException {
		lastName = util.recuperaCelulaString("Last Name");
		cadastroPage.setLastName(lastName);
	}
	@Quando("no campo Phone Number preencho {string}")
	public void noCampoPhoneNumberPreencho(String phoneNumber) throws IOException {
		phoneNumber = util.recuperaCelulaNumerica("Phone Number");
		cadastroPage.setPhoneNumber(phoneNumber);
	}
	@Quando("no campo Country preencho {string}")
	public void noCampoCountryPreencho(String country) throws InterruptedException, IOException {
		country = util.recuperaCelulaString("Country");
		cadastroPage.setCountry(country);
	}
	@Quando("no campo City preencho {string}")
	public void noCampoCityPreencho(String city) throws IOException {
		city = util.recuperaCelulaString("City");
		cadastroPage.setCity(city);
	}
	@Quando("no campo Address preencho {string}")
	public void noCampoAddressPreencho(String address) throws IOException {
		address = util.recuperaCelulaString("Address");
		cadastroPage.setAddress(address);
	}
	@Quando("no campo State Province Region preencho {string}")
	public void noCampoStateProvinceRegionPreencho(String stateProvinceRegion) throws IOException {
		stateProvinceRegion = util.recuperaCelulaString("State Province Region");
		cadastroPage.setStateProvinceRegion(stateProvinceRegion);
	}
	@Quando("no campo Postal Code preencho {string}")
	public void noCampoPostalCodePreencho(String postalCode) throws IOException {
		postalCode = util.recuperaCelulaNumerica("Postal Code");
		cadastroPage.setPostalCode(postalCode);
	}
	@Quando("verifico que a opcao Receber ofertas esta marcada")
	public void verificoQueAOpcaoReceberOfertasEstaMarcada() throws IOException {
		if (util.recuperaCelulaBoolean("Receber Ofertas")) {
			Assert.assertTrue(cadastroPage.permitePromocoesEstaSelecionado());
		} else {
			cadastroPage.clicaCheckboxEmailsPromocionais();
		}
	}
	@Quando("clico na opcao Aceitar termos")
	public void clicoNaOpcaoAceitarTermos() throws IOException {
		if (util.recuperaCelulaBoolean("Aceitar Termos")) {
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
	
	// --- steps consultando massa de testes do Excel --- //
	
	@Quando("preencho o campo {string}")
	public void preenchoOCampo(String campo) throws IOException {
		
	}
	@Quando("verifico que a opcao {string} esta marcada")
	public void verificoQueAOpcaoEstaMarcada(String string) {
	    
	}
	@Quando("clico na opcao {string}")
	public void clicoNaOpcao(String string) {
	    
	}
	@Entao("o sistema exibe a {string}")
	public void oSistemaExibeA(String string) {
	    
	}

}
