package steps;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LinkedinGlobal;
import pageobjects.LoginPage;
import utils.Browser;

public class StalenessCheck {

private LoginPage login = new LoginPage();
	
	@Given("^user is navigated to Login Page of linkedin$")
	 public void user_navigated_to_login_page_linkedin()  throws TimeoutException {
		login.navigateToLoginPage();
	 }
	
	 @When("^user enters username and password on login page of linkedin$")
	 public void user_enters_username_password_linkedin()  throws TimeoutException {
		 login.emailIdElm.sendKeys(LinkedinGlobal.USER_NAME);
		 login.psswdElm.sendKeys(LinkedinGlobal.PASSWORD);
	 }
	 
	 @When("^user refreshes browser and provides username and password$")
	 public void user_refreshes_browser_provide_credentials()  throws TimeoutException {
		 Browser.sleep(2000);
		 Browser.getDriver().navigate().refresh();
		 Browser.sleep(2000);
		 login.emailIdElm.sendKeys(LinkedinGlobal.USER_NAME);
		 login.psswdElm.sendKeys(LinkedinGlobal.PASSWORD);
	 }
	 
	 @When("^user clicks signin button of linkedin$")
	 public void user_click_signin_button_linkedin()  throws TimeoutException {
		 login.signInElm.click();
	 }
	 
	 @Then("^user lands on home page of linkedin and verifies title$")
	 public void user_landed_on_home_page()  throws TimeoutException {
		 String title = Browser.getDriver().getTitle();
		 Assert.assertEquals("LinkedIn", title);
		 // Browser.quitDriver();
	 }
	 
}
