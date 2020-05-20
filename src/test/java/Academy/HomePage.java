package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password, String user) throws IOException {
		
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		log.info("Navigated to Login Page");

		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
		log.info(user);

		ForgotPasswordPage fp = lp.getForgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();


	}

	@Test(enabled = false)
	public void navigateCourses() {
		LandingPage l = new LandingPage(driver);
//		if(l.getPopup().isEnabled()) {
//			l.getPopup().click();
//		} 
		l.getCourses().click();
		Assert.assertEquals(driver.getTitle(), "Rahul Shetty Academy");
		log.info("Navigated to Courses");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "RestrictedUser@gmail.com";
		data[0][1] = "Password";
		data[0][2] = "Restricted User";
		// 1st row
		data[1][0] = "NoneRestrictedUser@gmail.com";
		data[1][1] = "NewPassword!";
		data[1][2] = "None Restricted User";

		return data;
	}

}
