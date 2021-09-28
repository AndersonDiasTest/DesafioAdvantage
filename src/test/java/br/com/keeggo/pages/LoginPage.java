package br.com.keeggo.pages;

import org.openqa.selenium.By;

import br.com.keeggo.core.BasePage;

public class LoginPage extends BasePage {
	
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
		clicaBotao("sign_in_btnundefined");
	}
	
	public String obterUsuarioLogado() {
		esperaElementoSerClicavel(By.xpath("//a[@id='menuUserLink']/span"));
		return obterTexto(By.xpath("//a[@id='menuUserLink']/span"));
	}

	public String obterMsgLoginInvalido() {
		esperaMensagem(By.id("signInResultMessage"), "Incorrect user name or password.");
		return obterTexto(By.id("signInResultMessage"));
	}
	
}
