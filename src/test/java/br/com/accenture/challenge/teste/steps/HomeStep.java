package br.com.accenture.challenge.teste.steps;

import br.com.accenture.challenge.actions.HomeAction;
import io.cucumber.java.pt.Dado;

public class HomeStep {

	private HomeAction home = new HomeAction();

	/********* @Dado ************/

	@Dado("que tenha carregado o portal da Tricentis")
	public void queTenhaCarregadoOPortalDaTricentis() {
		home.confirmarTelaHomeCarregada();
	}
}
