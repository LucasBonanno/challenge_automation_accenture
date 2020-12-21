package br.com.accenture.challenge.pages;

import org.openqa.selenium.By;

public class SendoQuotePage {

	public final By email = By.id("email");
	public final By userName = By.id("username");
	public final By password = By.id("password");
	public final By confirmPassword = By.id("confirmpassword");
	public final By sendEmail = By.id("sendemail");
	public final By loading = By.id("LoadingPDF");
	public final By alert = By.xpath("//div[@class='sweet-alert showSweetAlert visible']/h2");
	
	

}
