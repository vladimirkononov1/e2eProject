package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AcademyPage;
import resources.Base;

public class ValidateAcademyPage extends Base{
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	public AcademyPage c;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("coursesUrl"));
		c = new AcademyPage(driver);

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	@Test
	public void validateLinkedinLink() {
//		c = new AcademyPage(driver);
		System.out.println(c.getLinkedin().getText());
		Assert.assertTrue(c.getLinkedin().isEnabled(), "Linkedin link is missing");
		log.info("Linkedin link is present");
	}
	
	@Test
	public void validateLogin() {
		Assert.assertEquals(c.getTitle().getText(), "Featured Courses", "Title is missing");
		Assert.assertTrue(c.getLogin().isEnabled(), "Login button is missing");
		log.info("Login button is present");
	}
	
	@Test
	public void validateTitle() {
		Assert.assertTrue(c.getTitle().isEnabled(), "Title is missing or wrong");
		log.info("Title contains \"" + c.getTitle().getText() + "\" text");
	}

	@Test
	public void validateLinks() {
		Assert.assertTrue(c.getCoreJava().isDisplayed(), "CoreJava Link is missing");
		Assert.assertTrue(c.getSelenium().isDisplayed(), "Selenium Link is missing");
		Assert.assertTrue(c.getJmeter().isDisplayed(), "Jeter Link is missing");
		Assert.assertTrue(c.getLearnSql().isDisplayed(), "SQL Link is missing");
		log.info("Courses links are present on the page");

	}
	
	@Test
	public void validateAppium() {
		Assert.assertTrue(c.getAppiumImage().isDisplayed(), "Appium Img is missing");
		Assert.assertTrue(c.getAppium().isDisplayed(), "Appium Link is missing");
		Assert.assertTrue(c.getAppiumSalePrice().isDisplayed(), "Appium sale price is missing");
		log.info("Appium link is validated");

	}

}
