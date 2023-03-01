package steps;

import org.junit.After;

import connections.DriversFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BuscaCepElements;
import pageObjects.HomeElements;

public class Steps extends DriversFactory {

	HomeElements el = new HomeElements();
	BuscaCepElements cepEl = new BuscaCepElements();

	@After
	public void close() {
		closeWindow();
	}

	@Given("que eu acesso o site dos correios na url {string}")
	public void queEuAcessoOSiteDosCorreiosNaUrl(String url) {
		connect(url);
	}

	@Given("clico no campo busca CEP ou endereco")
	public void clicoNoCampoBuscaCEPOuEndereco() {
		el.clickFieldBuscaCep();
	}

	@Given("preencho com o {string}")
	public void preenchoComO(String cep) {
		el.fillCepOrAdress(cep);
	}

	@When("clico em buscar")
	public void clicoEmBuscar() {
		el.clickBuscaCep();
	}

	@When("for levado a outra pagina")
	public void forLevadoAOutraPagina() {
		cepEl.checkTitle();
	}

	@Then("resultado deve ser {string}")
	public void resultadoDeveSer(String result) {
		if (result.equals("Não há dados a serem exibidos")) {
			cepEl.assertEmptyResult(result);
		} else if (result.equals("Rua Quinze de Novembro, São Paulo/SP")) {
			cepEl.assertResult(result);
		}
	}
}