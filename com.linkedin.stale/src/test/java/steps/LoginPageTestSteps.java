package steps;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import pageobjects.LinkedinGlobal;
import utils.Browser;

public class LoginPageTestSteps{
	
	private LoginPage login = new LoginPage();
	
	@Given("^user is navigated to Login Page$")
	 public void user_navigated_to_login_page()  throws TimeoutException {
		login.navigateToLoginPage();
	 }
	
	 @When("^user enters username and password on login page$")
	 public void user_enters_username_password()  throws TimeoutException {
		 login.emailIdElm.sendKeys(LinkedinGlobal.USER_NAME);
		 login.psswdElm.sendKeys(LinkedinGlobal.PASSWORD);
	 }
	 
	 @When("^user clicks signin button$")
	 public void user_click_signin_button()  throws TimeoutException {
		 login.signInElm.click();
	 }
		
	 @Then("^user lands on home page of linkedin$")
	 public void user_landed_on_home_page()  throws TimeoutException {
		 String title = Browser.getDriver().getTitle();
		 Assert.assertEquals("LinkedIn", title);
		 // Browser.quitDriver();
	 }
	 
}