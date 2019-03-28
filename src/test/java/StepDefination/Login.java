package StepDefination;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Login{
	
	public WebDriver driver;
	
	public Login() {
		driver = Hooks.eDriver;
	}

	@Given("^I go to yahoo$")
	public void i_go_to_yahoo() throws Throwable {
		System.out.println("Given");
		driver.get("https://www.google.com");
	}

	@When("^enter \"([^\"]*)\" in test field$")
	public void enter_in_test_field(String arg1) throws Throwable {
		System.out.println("When");
		assertTrue(false);
	}
	
}
