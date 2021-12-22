package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class LoginPage extends BasePage {
	
	public void clicaBotaoNovaConta() {
		esperaElementoSerClicavel(By.linkText("CREATE NEW ACCOUNT"));
		clicaLink("CREATE NEW ACCOUNT");
	}
	
	public void setUsername (String valor) {
		esperaElementoSerClicavel(By.name("username"));
		preencheByName("username", valor);
	}
	
	public void setPassword (String valor) {
		esperaElementoSerClicavel(By.name("password"));
		preencheByName("password", valor);
	}
	
	public void clicaBotaoSignIn() {
		esperaElementoSerClicavel(By.id("sign_in_btnundefined"));
		clicaBotaoById("sign_in_btnundefined");
	}

	public String obterMsgLoginInvalido() {
		esperaMensagemSer(By.id("signInResultMessage"), "Incorrect user name or password.");
		return obterTexto(By.id("signInResultMessage"));
	}
	
	public boolean botaoSignInEstaHabilitado() {
		return botaoEstaHabilitado("sign_in_btnundefined");
	}

	public String obterMsgCampoObrigatorio(String campo) {
		removeFocoCampo("signInResultMessage");
		return obterMensagem(campo);
	}

	public void clicaCheckboxRememberMe() {
		esperaElementoSerClicavel(By.name("remember_me"));
		clicaCheckboxByName("remember_me");
	}

	public void clicaBotaoSignOut() {
		esperaElementoSerClicavel(By.xpath("//*[@id='loginMiniTitle']//label[contains(text(), 'Sign out')]"));
		clicaBotao(By.xpath("//*[@id='loginMiniTitle']//label[contains(text(), 'Sign out')]"));
	}
	
	public String getUsernameValue() {
		esperaElementoSerClicavel(By.name("username"));
		return obterValorPreenchido("username");
	}
	
	public String getPasswordValue() {
		esperaElementoSerClicavel(By.name("password"));
		return obterValorPreenchido("password");
	}
	
	public boolean rememberMeEstaSelecionado() {
		esperaElementoSerClicavel(By.name("remember_me"));
		return checkboxEstaSelecionado("remember_me");
	}
}
