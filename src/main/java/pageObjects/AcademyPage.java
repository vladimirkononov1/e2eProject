package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcademyPage {

	public WebDriver driver;
	
	private By linkedin = By.cssSelector(".fa.fa-linkedin");
	private By register = By.xpath("//a[@class='theme-btn register-btn']");
	private By login = By.xpath("//a[contains(text(),'Login')]");
	private By join = By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	//Featured Courses links
	
	private By coreJava = By.xpath("//h2/a[contains(text(), 'Core java for Automation Testers')]");
	private By seleniumWebdriver = By.xpath("//a[contains(text(),'Selenium Webdriver')]");
	private By jmeter = By.xpath("//a[contains(text(),'Learn JMETER')]");
	private By learnSql = By.xpath("//a[contains(text(),'Learn SQL')]");
	private By appium = By.xpath("//a[contains(text(),'Appium (Selenium) - Mobile Automation Testing from')]");
	private By appiumImg = By.xpath("//img[contains (@src, 'assets/images/resource/appium.jpg')]");
	private By appiumSalePrice = By.xpath("//a[contains(text(),'100')]");
	
	
	public AcademyPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getRegister() {
		return driver.findElement(register);
	}

	public WebElement getLinkedin() {
		return driver.findElement(linkedin);
	}
	
	public WebElement getJoin() {
		return driver.findElement(join);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getCoreJava() {
		return driver.findElement(coreJava);
	}
	public WebElement getSelenium() {
		return driver.findElement(seleniumWebdriver);
	}
	public WebElement getJmeter() {
		return driver.findElement(jmeter);
	}
	public WebElement getLearnSql() {
		return driver.findElement(learnSql);
	}
	
	public WebElement getAppium() {
		return driver.findElement(appium);
	}

	public WebElement getAppiumImage() {
		return driver.findElement(appiumImg);
	}

	public WebElement getAppiumSalePrice() {
		return driver.findElement(appiumSalePrice);
	}
}
