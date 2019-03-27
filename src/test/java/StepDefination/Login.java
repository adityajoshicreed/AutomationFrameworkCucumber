package StepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Login {

	@Given("^I go to yahoo$")
	public void i_go_to_yahoo() throws Throwable {
		System.out.println("Given");
	}

	@When("^enter \"([^\"]*)\" in test field$")
	public void enter_in_test_field(String arg1) throws Throwable {
		System.out.println("When");
	}
	
}
