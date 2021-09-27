package br.com.keeggo.steps;

import static br.com.keeggo.core.DriverFactory.killDriver;

import org.junit.Assert;

import br.com.keeggo.core.Propriedades;
import br.com.keeggo.pages.CadastroPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
	
	private CadastroPage cadastroPage = new CadastroPage();

//	@Dado("que eu acesso a aplicacao")
//	public void queEuAcessoAAplicacao() {
//	    cadastroPage.acessarPaginaInicial();
//	}
//	@Quando("clico no icone de usuario")
//	public void clicoNoIconeDeUsuario() {
//	    cadastroPage.clicaBotaoUsuario();
//	}
	
	@Quando("clico na opcao Create New Account")
	public void clicoNaOpcaoCreateNewAccount() {
	    cadastroPage.clicaBotaoNovaConta();
	}
	@Quando("no campo Username preencho {string}")
	public void noCampoUsernamePreencho(String username) {
	    cadastroPage.setUsername(username);
	}
	@Quando("no campo Email preencho {string}")
	public void noCampoEmailPreencho(String email) {
	    cadastroPage.setEmail(email);
	}
	@Quando("no campo Password preencho {string}")
	public void noCampoPasswordPreencho(String password) {
	    cadastroPage.setPassword(password);
	}
	@Quando("no campo Confirm Password preencho {string}")
	public void noCampoConfirmPasswordPreencho(String confirmPassword) {
		cadastroPage.setConfirmPassword(confirmPassword);
	}
	@Quando("no campo First Name preencho {string}")
	public void noCampoFirstNamePreencho(String firstName) {
	    cadastroPage.setFirstName(firstName);
	}
	@Quando("no campo Last Name preencho {string}")
	public void noCampoLastNamePreencho(String lastName) {
		cadastroPage.setLastName(lastName);
	}
	@Quando("no campo Phone Number preencho {string}")
	public void noCampoPhoneNumberPreencho(String phoneNumber) {
		cadastroPage.setPhoneNumber(phoneNumber);
	}
	@Quando("no campo Country preencho {string}")
	public void noCampoCountryPreencho(String country) {
		cadastroPage.setCountry(country);
	}
	@Quando("no campo City preencho {string}")
	public void noCampoCityPreencho(String city) {
		cadastroPage.setCity(city);
	}
	@Quando("no campo Address preencho {string}")
	public void noCampoAddressPreencho(String address) {
		cadastroPage.setAddress(address);
	}
	@Quando("no campo State Province Region preencho {string}")
	public void noCampoStateProvinceRegionPreencho(String stateProvinceRegion) {
		cadastroPage.setStateProvinceRegion(stateProvinceRegion);
	}
	@Quando("no campo Postal Code preencho {string}")
	public void noCampoPostalCodePreencho(String postalCode) {
		cadastroPage.setPostalCode(postalCode);
	}
	@Quando("verifico que a opcao Receber ofertas esta marcada")
	public void verificoQueAOpcaoReceberOfertasEstaMarcada() {
	    Assert.assertTrue(cadastroPage.permitePromocoesEstaSelecionado());
	}
	@Quando("clico na opcao Aceitar termos")
	public void clicoNaOpcaoAceitarTermos() {
	    cadastroPage.aceitaTermos();
	}
	@Quando("clico na opcao Register")
	public void clicoNaOpcaoRegister() {
	    
	}
	@Entao("o sistema exibe a mensagem {string}")
	public void oSistemaExibeAMensagem(String mensagem) {
	    
	}
	@Entao("a opcao Register fica desabilitado")
	public void aOpcaoRegisterFicaDesabilitado() {
	    
	}
	
	@After
	public void finaliza () {
		if (Propriedades.FECHAR_BROWSER) {
//			killDriver();
		}
	}
}
