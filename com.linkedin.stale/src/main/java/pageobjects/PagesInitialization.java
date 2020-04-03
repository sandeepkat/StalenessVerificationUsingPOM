package pageobjects;

import org.openqa.selenium.support.PageFactory;

import utils.Browser;

public abstract class PagesInitialization {

		/*
		 * Super class which initializes the web elements upon object creation
		 * 
		 */
		public PagesInitialization()
		{
			PageFactory.initElements(Browser.getDriver(), this);
		}
}
