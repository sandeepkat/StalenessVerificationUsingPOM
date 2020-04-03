package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Browser;

public class LoginPage extends PagesInitialization{

		/*
		 * Define a unique element of a page, useful to verify that the user is one
		 * login page
		 */

		public void navigateToLoginPage() {
			Browser.open(LinkedinGlobal.LINKEDIN_LOGIN_URL);
		}

		@FindBy(id = "username")
		public WebElement emailIdElm;
		
		@FindBy(id = "password")
		public WebElement psswdElm;

		@FindBy(css = "#app__container > main > div > form > div.login__form_action_container > button")
		public WebElement signInElm;
		
}
