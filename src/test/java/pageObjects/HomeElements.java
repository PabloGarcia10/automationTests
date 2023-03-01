package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import connections.DriversFactory;

public class HomeElements extends DriversFactory {

	private By cepField = By.id("relaxation");

	public void clickFieldBuscaCep() {
		driver.findElement(cepField).click();
	}

	public void fillCepOrAdress(String cep) {
		driver.findElement(cepField).sendKeys(cep);
		;
	}
	
	public void clickBuscaCep() {
		driver.findElement(cepField).sendKeys(Keys.ENTER);
	}
}
