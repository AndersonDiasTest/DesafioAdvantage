package br.com.keeggo.core;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.keeggo.steps",
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		tags = "not @ignore",
		monochrome = true,
		dryRun = false,
		snippets = SnippetType.CAMELCASE
		)
public class Runner {
	

}
