package br.com.accenture.challenge.pages;

import org.openqa.selenium.By;

public class FormEnterVehicleDataPage {

	public final By logoTricentis = By.id("branding");
	public final By make = By.id("make");
	public final By model = By.id("model");
	public final By cylinderCapacity = By.id("cylindercapacity");
	public final By enginePerformance = By.id("engineperformance");
	public final By dateOfManufacture = By.id("dateofmanufacture");
	public final By numberOfSeats = By.id("numberofseats");
	public final By rightHandDriveNo = By.xpath("//input[@id='righthanddriveno']/../span");
	public final By numberOfSeatsMotorcycle = By.id("numberofseatsmotorcycle");
	public final By fuel = By.id("fuel");
	public final By payload = By.id("payload");
	public final By totalWeight = By.id("totalweight");
	public final By listPrice = By.id("listprice");
	public final By licensePlateNumber = By.id("licenseplatenumber");
	public final By annualMileage = By.id("annualmileage");
	public final By btnNextVehicleData = By.id("nextenterinsurantdata");

}
