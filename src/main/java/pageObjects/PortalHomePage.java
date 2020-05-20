package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {

	public WebDriver driver;

	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.name("query");
	By forgotPassword = By.cssSelector("[href*='password/new']");


	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

}
