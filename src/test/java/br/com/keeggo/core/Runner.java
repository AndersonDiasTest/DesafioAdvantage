package br.com.keeggo.core;

import org.junit.After;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/ConsultarProduto.feature",
		glue = "br.com.keeggo.steps",
		tags = "not @ignore",
		monochrome = true,
		dryRun = true,
		snippets = SnippetType.CAMELCASE
		)
public class Runner {

	@After
	public void finaliza() {
		if (Propriedades.FECHAR_BROWSER) {
//			killDriver();
		}
	}
}
