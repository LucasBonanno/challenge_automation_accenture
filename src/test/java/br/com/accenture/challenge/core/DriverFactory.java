package br.com.accenture.challenge.core;

import java.nio.file.Paths;

//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

	private static WebDriver driver;
	private static WebDriverWait waitDriver;

	private static String webdriver = ""; 

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				webdriver = Paths.get("").toAbsolutePath().toString() + "/drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", webdriver);
				driver = new FirefoxDriver();
				break;
			case CHROME:
				webdriver = Paths.get("").toAbsolutePath().toString() + "/drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", webdriver);
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static WebDriverWait getWaitDriver() {
		waitDriver = new WebDriverWait(driver, 10);
		return waitDriver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
