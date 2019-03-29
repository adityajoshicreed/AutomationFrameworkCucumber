package StepDefination;

import static org.testng.Assert.assertTrue;

import base.BaseClass;
import constants.WebElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.Methods;

public class Login extends Methods{

	public Login(BaseClass base) {
		super(base);
	}

	@Given("^I go to yahoo$")
	public void i_go_to_yahoo() throws Throwable {
		input(WebElements.usernameField,"adi");
		click(WebElements.signinButton);
	}

	@When("^enter \"([^\"]*)\" in test field$")
	public void enter_in_test_field(String arg1) throws Throwable {
		assertTrue(true);
	}
	
}
