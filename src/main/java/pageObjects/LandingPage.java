package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath(".//div[@class='text-center']/h2");
	private By navBar = By.xpath(".//div[@class='container']/nav/ul");
	private By courses = By.cssSelector("ul.nav.navbar-nav.navbar-right > li:nth-child(2)");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getCourses() {
		return driver.findElement(courses);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public int getPopUpSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}


}
