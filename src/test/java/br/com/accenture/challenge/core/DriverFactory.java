package br.com.accenture.challenge.core;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.accenture.challenge.utils.Utils;

public class DriverFactory {

	private static WebDriver driver;
	private static WebDriverWait waitDriver;

	private static String webdriver = ""; 

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		
		final String path = getPathFromWebDriverByOSName();
		final String extension = getExtensionByOSName();
		
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				webdriver = path + "/geckodriver" + extension;
				System.setProperty("webdriver.gecko.driver", webdriver);
				driver = new FirefoxDriver();
				break;
			case CHROME:
				webdriver = path + "/chromedriver" + extension;
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
	
	private static String getPathFromWebDriverByOSName() {
		final String fullPath = Paths.get("").toAbsolutePath().toString();
		return Utils.isUnix() ? fullPath + "/drivers/mac" : fullPath + "/drivers";
	}
	
	private static String getExtensionByOSName() {
		return Utils.isUnix() ? "" : ".exe";
	}
}
