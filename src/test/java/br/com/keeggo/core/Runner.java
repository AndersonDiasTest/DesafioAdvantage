package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/CadastroUsuario.feature",
		glue = "br.com.keeggo.steps",
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		tags = "not @ignore",
		monochrome = true,
		dryRun = true,
		snippets = SnippetType.CAMELCASE
		)
public class Runner {
	
	@AfterClass
	public static void finaliza() {
//		killDriver();
	}
}
