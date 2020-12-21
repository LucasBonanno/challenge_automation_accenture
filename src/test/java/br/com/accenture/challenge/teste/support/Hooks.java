package br.com.accenture.challenge.teste.support;

import static br.com.accenture.challenge.core.DriverFactory.getDriver;
import static br.com.accenture.challenge.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.accenture.challenge.core.DriverFactory;
import br.com.accenture.challenge.core.PropertyReader;
import br.com.accenture.challenge.core.Propriedades;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Rule
	public TestName name = new TestName();

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Iniciando a execução do teste: " + scenario.getName());
		Thread.currentThread().setName(scenario.getName());
		getDriver().get(PropertyReader.getProperty("web.url"));
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String status = scenario.getStatus().toString();
		FileUtils.copyFile(arquivo, new File("evidences" + File.separator + "screenshot_status_" + status
				+ File.separator + scenario.getName() + ".jpg"));
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}

	}
}
