package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import connections.DriversFactory;

public class BuscaCepElements extends DriversFactory {

	private By resultMessage = By.id("mensagem-resultado");
	private By name = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]");
	private By uf = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[3]");

	public void checkTitle() {
		secondTab();
		Assert.assertEquals(driver.getTitle(), "Busca CEP");
	}

	public void assertEmptyResult(String result) {
			String textMessage = driver.findElement(resultMessage).getText();
			Assert.assertTrue(textMessage.contains(result));
	}

	public void assertResult(String result) {
		String streetName = driver.findElement(name).getText().replace(" - lado ímpar", ", ");
		String resultUF = driver.findElement(uf).getText();
		String concatResult = streetName + resultUF;

		Assert.assertEquals(concatResult, result);
	}
}
