package br.com.accenture.challenge.pages;

import org.openqa.selenium.By;

public class FormEnterProductDataPage {

	public final By startDate = By.id("startdate");
	public final By insuranceSum = By.id("insurancesum");
	public final By meritRating = By.id("meritrating");
	public final By damageInsurance = By.id("damageinsurance");
	public final By legalDefenseInsurance = By.xpath("//input[@id='LegalDefenseInsurance']/../span");
	public final By courtesyCar = By.id("courtesycar");
	public final By btnNextProductData = By.id("nextselectpriceoption");

}
