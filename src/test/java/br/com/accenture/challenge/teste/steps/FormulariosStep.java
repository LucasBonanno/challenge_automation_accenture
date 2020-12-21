package br.com.accenture.challenge.teste.steps;

import br.com.accenture.challenge.actions.FormulariosAction;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class FormulariosStep {

	private FormulariosAction formulario = new FormulariosAction();

	/********* @Dado ************/

	@Quando("preencher o formulario Enter Vehicle Data")
	public void preencherOFormularioEnterVehicleData() {
		formulario.preencher();
	}

	@Quando("o formulario Enter Insurant Data")
	public void oFormularioEnterInsurantData() {
		formulario.preencher();
	}

	@Quando("o formulario Enter Product Data")
	public void oFormularioEnterProductData() {
		formulario.preencher();
	}

	@Quando("selecionar opcao de precos")
	public void selecionarOpcaoDePrecos() {
		formulario.selecionarOpcaoCotaOuro();
	}

	/********* @Entao ************/

	@Entao("sera possivel enviar cota")
	public void seraPossivelEnviarCota() {
		formulario.enviarCota();
	}

	@Entao("sera possivel Verificar a mensagem {string}")
	public void seraPossivelVerificarAMensagem(String mensagem) {
		formulario.confirmarMensagemDeEnvio(mensagem);
	}

}
