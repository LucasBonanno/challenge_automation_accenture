package br.com.accenture.challenge.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/",
		glue = "br.com.accenture.challenge.teste",
		tags = {"@ChallengeAccenture"},
		plugin = {"pretty", "html:evidences/report-html"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		)
public class RunCucumberTest {
}
