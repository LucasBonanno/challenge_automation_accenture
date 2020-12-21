package br.com.accenture.challenge.core;

import static br.com.accenture.challenge.core.DriverFactory.getDriver;
import static br.com.accenture.challenge.core.DriverFactory.getWaitDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	/********* TextField e TextArea ************/

	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	/********* Combo ************/

	public void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selectVisivelTexto(By locator, String value) {
		Select select = new Select(getDriver().findElement(locator));
		select.selectByVisibleText(value);
	}

	/********* Botao ************/

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	/********* Textos ************/

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	/********* Alerts ************/

	public boolean isAlertPresente() throws InterruptedException {
		try {
			getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

	/************** Table *********************/

	public String[] obterValoresLinha(By listaFuncionarios, int linha) {
		WebElement table = getDriver().findElement(listaFuncionarios);
		String[] tr = table.findElement(By.xpath("./tbody/tr[" + linha + "]")).getText().split(" ");
		return tr;
	}

	/************** Wait *********************/
	
	public void locatorVisivel(By locator) {
		getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public Boolean isNotVisible(By locator) {
		return getWaitDriver().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public boolean isVisible(By locator) {
		try {
			locatorVisivel(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
