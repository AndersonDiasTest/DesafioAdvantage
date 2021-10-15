package br.com.keeggo.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;
import br.com.keeggo.core.Utils;

public class CadastroPage extends BasePage {
	
	private Utils util = new Utils();

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

	public void preencheCampo(String campo) throws IOException, InterruptedException {
		switch (campo) {
		case "Username":
			String username = util.recuperaCelulaString("Username");
			setUsername(username);
			break;
		case "Email":
			String email = util.recuperaCelulaString("Email");
			setEmail(email);
			break;
		case "Password":
			String password = util.recuperaCelulaString("Password");
			setPassword(password);
			break;
		case "Confirm Password":
			String confirmPassword = util.recuperaCelulaString("Confirm Password");
			setConfirmPassword(confirmPassword);
			break;
		case "First Name":
			String firstName = util.recuperaCelulaString("First Name");
			setFirstName(firstName);
			break;
		case "Last Name":
			String lastName = util.recuperaCelulaString("Last Name");
			setLastName(lastName);
			break;
		case "Phone Number":
			String phoneNumber = util.recuperaCelulaNumerica("Phone Number");
			setPhoneNumber(phoneNumber);
			break;
		case "Country":
			String country = util.recuperaCelulaString("Country");
			setCountry(country);
			break;
		case "City":
			String city = util.recuperaCelulaString("City");
			setCity(city);
			break;
		case "Address":
			String address = util.recuperaCelulaString("Address");
			setAddress(address);
			break;
		case "State Province Region":
			String stateProvinceRegion = util.recuperaCelulaString("State Province Region");
			setStateProvinceRegion(stateProvinceRegion);
			break;
		case "Postal Code":
			String postalCode = util.recuperaCelulaNumerica("Postal Code");
			setPostalCode(postalCode);
			break;
		default:
			break;
		}
	}

	public void clicaCheckboxEmailsPromocionais() {
		clicaCheckboxByName("allowOffersPromotion");
	}

	public void clicaCheckboxTermos() {
		clicaCheckboxByName("i_agree");
	}

	public void clicaBotaoRegister() {
		esperaElementoSerClicavel(By.id("register_btnundefined"));
		clicaBotaoById("register_btnundefined");
	}

	public boolean permiteEmailsPromocionaisEstaSelecionado() {
		return checkboxEstaSelecionado("allowOffersPromotion");
	}

	public String obterMsgCampoObrigatorio(String campo) {
		return obterMensagem(campo);
	}

	public String obterMsgContaJaExistente() {
		esperaMensagemSer(By.xpath("//*[@id='register_btnundefined']/../../label[1]"), "User name already exists");
		return obterTexto(By.xpath("//*[@id='register_btnundefined']/../../label[1]"));
	}

	public boolean botaoRegisterEstaHabilitado() {
		return botaoEstaHabilitado("register_btnundefined");
	}
}
