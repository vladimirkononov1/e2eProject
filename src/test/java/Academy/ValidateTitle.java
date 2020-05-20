package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
//		driver = null;
	}

	@Test
	public void validateAppTitle() throws IOException {
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123", "App Title is missing or wrong.");
		log.info("Successfully validated Text message");

		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation Bar is displayed");

	}

	@Test
	public void validateHeader() {
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING",
				"Title text is missing.");
	}

	@Test
	public void validateCoursesLink() {
		Assert.assertEquals(l.getCourses().getText(), "COURSES", "Link text is wrong.");
	}

}
