package br.com.accenture.challenge.actions;

import br.com.accenture.challenge.core.BaseAction;
import br.com.accenture.challenge.pages.HomePage;

public class HomeAction extends BaseAction {

	private HomePage loginPage = new HomePage();

	public void confirmarTelaHomeCarregada() {
		verificarElementosCarregadoNaPage(loginPage.logoTricentis, loginPage.barraHeader, loginPage.menuForm,
				loginPage.formVihicleData);
		assertiva(loginPage.navHome, "web.home.expected");
	}
}
