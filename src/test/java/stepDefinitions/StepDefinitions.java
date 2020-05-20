package stepDefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

public class StepDefinitions extends Base{

	LoginPage lp = new LoginPage(driver);
	
	@Given("Initialized the browser with chrome")
	public void initialized_the_browser_with_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();

	}

	@Given("Navigate to {string} Site")
	public void navigate_to_Site(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(string);
	}

	@Given("Click on Login link in home page to land on Secure sign in Page")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		if(l.getPopUpSize() > 0) {
			l.getPopUp().click();
		}
		lp = l.getLogin();
	}

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();	
    }

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		try {
			PortalHomePage p = new PortalHomePage(driver);
			Assert.assertTrue(p.getSearchBox().isDisplayed());

		} catch(NoSuchElementException e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}
		
	}

    @And("^close browsers$")
    public void close_browsers() throws Throwable {
    	driver.quit();
    }

}
