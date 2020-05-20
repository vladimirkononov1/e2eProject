package Academy;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;

	}

	@Test
	public void validateAppNavigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation Bar is displayed");

	}

}
