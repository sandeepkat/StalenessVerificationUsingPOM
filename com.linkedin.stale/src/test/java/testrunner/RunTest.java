package testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.Browser;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/java/features/",							 //the path of the feature files
			glue={"steps"}, 												 //the path of the steps files
			plugin= {"pretty", "html:target/cucumber-html-report"}, 		 //to generate different types of reporting
			monochrome = true, 												 //display the console output in a proper readable format
			strict = false, 												 //it will check if any step is not defined in step definition file
			dryRun = false, 								  			 	//to check the mapping is proper between feature file and step def file
			tags = {"@StaleCheck"}			
			)
		 
	public class RunTest {
	 
		@AfterClass
		public static void teardown() {
			Browser.quitDriver();
		}
	}