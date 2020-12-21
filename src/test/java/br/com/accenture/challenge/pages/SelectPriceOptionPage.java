package br.com.accenture.challenge.pages;

import org.openqa.selenium.By;

public class SelectPriceOptionPage {

	public final By priceTable = By.id("priceTable");
	public final By selectGold = By.xpath("//input[@id='selectgold']/../span");
	public final By viewQuotePdf = By.xpath("//div[@id='quote-container'][@style='display: block;']");
	public final By nextSendQuote = By.id("nextsendquote");
}
