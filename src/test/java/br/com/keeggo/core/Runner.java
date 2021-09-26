package br.com.keeggo.core;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.keeggo.steps",
		tags = "not @ignore",
		monochrome = true
		)
public class Runner {

}
