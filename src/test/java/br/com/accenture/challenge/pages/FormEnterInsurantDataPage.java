package br.com.accenture.challenge.pages;

import org.openqa.selenium.By;

public class FormEnterInsurantDataPage {

	public final By firstName = By.id("firstname");
	public final By lastName = By.id("lastname");
	public final By birthDate = By.id("birthdate");
	public final By genderMale = By.xpath("//input[@id='gendermale']/../span");
	public final By streetAddress = By.id("streetaddress");
	public final By country = By.id("country");
	public final By zipCode = By.id("zipcode");
	public final By city = By.id("city");
	public final By occupation = By.id("occupation");
	public final By cliffdiving = By.xpath("//input[@id='cliffdiving']/../span");
	public final By website = By.id("website");
	public final By btnNextInsurantData = By.id("nextenterproductdata");

}
