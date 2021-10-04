package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class CadastroPage extends BasePage {

	public void clicaBotaoNovaConta() {
		esperaElementoSerClicavel(By.linkText("CREATE NEW ACCOUNT"));
		clicaLink("CREATE NEW ACCOUNT");
	}

	public void setUsername(String nome) {
		esperaElementoSerClicavel(By.name("usernameRegisterPage"));
		preencheByName("usernameRegisterPage", nome);
	}
	
	public void setEmail(String email) {
		esperaElementoSerClicavel(By.name("emailRegisterPage"));
		preencheByName("emailRegisterPage", email);
	}

	public void setPassword(String password) {
		esperaElementoSerClicavel(By.name("passwordRegisterPage"));
		preencheByName("passwordRegisterPage", password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		esperaElementoSerClicavel(By.name("confirm_passwordRegisterPage"));
		preencheByName("confirm_passwordRegisterPage", confirmPassword);
	}

	public void setFirstName(String firstName) {
		esperaElementoSerClicavel(By.name("first_nameRegisterPage"));
		preencheByName("first_nameRegisterPage", firstName);
	}
	
	public void setLastName(String lastName) {
		esperaElementoSerClicavel(By.name("last_nameRegisterPage"));
		preencheByName("last_nameRegisterPage", lastName);
	}
	
	public void setPhoneNumber(String phoneNumber) {
		esperaElementoSerClicavel(By.name("phone_numberRegisterPage"));
		preencheByName("phone_numberRegisterPage", phoneNumber);
	}
	
	public void setCountry(String country) throws InterruptedException {
		esperaElementoSerClicavel(By.name("countryListboxRegisterPage"));
		Thread.sleep(5000);
		selecionaOpcaoCombo("countryListboxRegisterPage", country);
	}

	public void setCity(String city) {
		esperaElementoSerClicavel(By.name("cityRegisterPage"));
		preencheByName("cityRegisterPage", city);
	}
	
	public void setAddress(String address) {
		esperaElementoSerClicavel(By.name("addressRegisterPage"));
		preencheByName("addressRegisterPage", address);
	}

	public void setStateProvinceRegion(String stateProvinceRegion) {
		esperaElementoSerClicavel(By.name("state_/_province_/_regionRegisterPage"));
		preencheByName("state_/_province_/_regionRegisterPage", stateProvinceRegion);
	}
	
	public void setPostalCode(String postalCode) {
		esperaElementoSerClicavel(By.name("postal_codeRegisterPage"));
		preencheByName("postal_codeRegisterPage", postalCode);
	}
	
	public boolean permitePromocoesEstaSelecionado() {
		return checkboxEstaSelecionado("allowOffersPromotion");
	}

	public void aceitaTermos() {
		clicaCheckbox("i_agree");
	}
	
	public void clicaRegister() {
		esperaElementoSerClicavel(By.id("register_btnundefined"));
		clicaBotao("register_btnundefined");
	}
	
	public String obterMsgCampoObrigatorio(String campo) {
		return obterMensagem(campo);
	}
	
	public String obterMsgContaJaExistente() {
		esperaMensagem(By.xpath("//*[@id='register_btnundefined']/../../label[1]"), "User name already exists");
		return obterTexto(By.xpath("//*[@id='register_btnundefined']/../../label[1]"));
	}
	
	public boolean botaoRegisterEstaHabilitado() {
		return botaoEstaHabilitado("register_btnundefined");
	}
}
