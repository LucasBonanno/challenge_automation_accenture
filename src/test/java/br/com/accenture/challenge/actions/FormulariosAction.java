package br.com.accenture.challenge.actions;

import org.junit.Assert;

import br.com.accenture.challenge.core.BaseAction;
import br.com.accenture.challenge.core.PropertyReader;
import br.com.accenture.challenge.pages.FormEnterInsurantDataPage;
import br.com.accenture.challenge.pages.FormEnterProductDataPage;
import br.com.accenture.challenge.pages.FormEnterVehicleDataPage;
import br.com.accenture.challenge.pages.SelectPriceOptionPage;
import br.com.accenture.challenge.pages.SendoQuotePage;

public class FormulariosAction extends BaseAction {

	private FormEnterVehicleDataPage formVehicle = new FormEnterVehicleDataPage();
	private FormEnterInsurantDataPage formInsurant = new FormEnterInsurantDataPage();
	private FormEnterProductDataPage formProduct = new FormEnterProductDataPage();
	private SelectPriceOptionPage selectPrice = new SelectPriceOptionPage();
	private SendoQuotePage sendQuote = new SendoQuotePage();

	public void preencher() {
		if (dsl.isVisible(formVehicle.make)) {
			formularioEnterVehicleData();
		}
		if (dsl.isVisible(formInsurant.firstName)) {
			formularioEnterInsurantData();
		}
		if (dsl.isVisible(formProduct.startDate)) {
			formularioEnterProductData();
		}
	}

	private void formularioEnterVehicleData() {
		try {
			dsl.selectVisivelTexto(formVehicle.make, PropertyReader.getProperty("make"));
			dsl.selectVisivelTexto(formVehicle.model, PropertyReader.getProperty("model"));
			dsl.escrever(formVehicle.cylinderCapacity, PropertyReader.getProperty("cylinderCapacity"));
			dsl.escrever(formVehicle.enginePerformance, PropertyReader.getProperty("enginePerformance"));
			dsl.escrever(formVehicle.dateOfManufacture, PropertyReader.getProperty("dateOfManufacture"));
			dsl.selectVisivelTexto(formVehicle.numberOfSeats, PropertyReader.getProperty("numberOfSeats"));
			dsl.clicarBotao(formVehicle.rightHandDriveNo);
			dsl.selectVisivelTexto(formVehicle.numberOfSeatsMotorcycle,
					PropertyReader.getProperty("numberOfSeatsMotorcycle"));
			dsl.selectVisivelTexto(formVehicle.fuel, PropertyReader.getProperty("fuelType"));
			dsl.escrever(formVehicle.payload, PropertyReader.getProperty("payload"));
			dsl.escrever(formVehicle.totalWeight, PropertyReader.getProperty("totalWeight"));
			dsl.escrever(formVehicle.listPrice, PropertyReader.getProperty("listPrice"));
			dsl.escrever(formVehicle.licensePlateNumber, PropertyReader.getProperty("licensePlateNumber"));
			dsl.escrever(formVehicle.annualMileage, PropertyReader.getProperty("annualMileage"));
			dsl.clicarBotao(formVehicle.btnNextVehicleData);
		} catch (Exception e) {
			Assert.fail("MSG AUTOMAÇÃO:\nNão foi possível preencher totalmente o formulário Vehicle Data.\nMSG ERROR:\n"
					+ e.getMessage());
		}
	}

	private void formularioEnterInsurantData() {
		try {
			dsl.escrever(formInsurant.firstName, PropertyReader.getProperty("firstName"));
			dsl.escrever(formInsurant.lastName, PropertyReader.getProperty("lastName"));
			dsl.escrever(formInsurant.birthDate, PropertyReader.getProperty("dateOfBirth"));
			dsl.clicarBotao(formInsurant.genderMale);
			dsl.escrever(formInsurant.streetAddress, PropertyReader.getProperty("streetAddress"));
			dsl.selectVisivelTexto(formInsurant.country, PropertyReader.getProperty("country"));
			dsl.escrever(formInsurant.zipCode, PropertyReader.getProperty("zipCode"));
			dsl.escrever(formInsurant.city, PropertyReader.getProperty("city"));
			dsl.selectVisivelTexto(formInsurant.occupation, PropertyReader.getProperty("occupation"));
			dsl.clicarBotao(formInsurant.cliffdiving);
			dsl.clicarBotao(formInsurant.btnNextInsurantData);
		} catch (Exception e) {
			Assert.fail(
					"MSG AUTOMAÇÃO:\nNão foi possível preencher totalmente o formulário Insurant Data.\nMSG ERROR:\n"
							+ e.getMessage());
		}
	}

	private void formularioEnterProductData() {
		try {
			dsl.escrever(formProduct.startDate, PropertyReader.getProperty("startDate"));
			dsl.selectVisivelTexto(formProduct.insuranceSum, PropertyReader.getProperty("insuranceSum"));
			dsl.selectVisivelTexto(formProduct.meritRating, PropertyReader.getProperty("meritRating"));
			dsl.selectVisivelTexto(formProduct.damageInsurance, PropertyReader.getProperty("damageInsurance"));
			dsl.clicarBotao(formProduct.legalDefenseInsurance);
			dsl.selectVisivelTexto(formProduct.courtesyCar, PropertyReader.getProperty("courtesyCar"));
			dsl.clicarBotao(formProduct.btnNextProductData);
		} catch (Exception e) {
			Assert.fail("MSG AUTOMAÇÃO:\nNão foi possível preencher totalmente o formulário Product Data.\nMSG ERROR:\n"
					+ e.getMessage());
		}
	}

	public void selecionarOpcaoCotaOuro() {
		try {
			if (dsl.isVisible(selectPrice.priceTable)) {
				dsl.clicarBotao(selectPrice.selectGold);
				dsl.isVisible(selectPrice.viewQuotePdf);
				dsl.clicarBotao(selectPrice.nextSendQuote);
			} else {
				throw new Exception("Não foi possível encontrar a tabela de preços na tela 'Select Price Option'");
			}
		} catch (Exception e) {
			Assert.fail(
					"MSG AUTOMAÇÃO:\nNão foi possível selecionar opção 'ouro' na tabela de valores de cota.\nMSG ERROR:\n"
							+ e.getMessage());
		}
	}

	public void enviarCota() {
		try {
			if (dsl.isVisible(sendQuote.email)) {
				dsl.escrever(sendQuote.email, PropertyReader.getProperty("email"));
				dsl.escrever(sendQuote.userName, PropertyReader.getProperty("firstName"));
				dsl.escrever(sendQuote.password, PropertyReader.getProperty("password"));
				dsl.escrever(sendQuote.confirmPassword, PropertyReader.getProperty("password"));
				dsl.clicarBotao(sendQuote.sendEmail);
			}
		} catch (Exception e) {
			Assert.fail("MSG AUTOMAÇÃO:\nNão foi possível enviar cota por e-mail.\nMSG ERROR:\n" + e.getMessage());
		}
	}

	public void confirmarMensagemDeEnvio(String mensagem) {
		try {
			if (dsl.isNotVisible(sendQuote.loading)) {
				dsl.isVisible(sendQuote.alert);
				String texto = dsl.obterTexto(sendQuote.alert).replaceAll("\\s+", " ");
				Assert.assertEquals(mensagem, texto);
			} else {
				throw new Exception("Não foi encontrado na tela o pop up de envio com sucesso!");
			}
		} catch (Exception e) {
			Assert.fail("MSG AUTOMAÇÃO:\nNão foi possível validar envio da cota por e-mail.\nMSG ERROR:\n"
					+ e.getMessage());
		}
	}

}
