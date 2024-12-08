package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentStep {

	@Then("user navigates to the payment page")
	public void user_navigates_to_the_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Payment page");
	}

	@When("user enters valid payment details")
	public void user_enters_valid_payment_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter valid Payment details");
	}

	@When("user clicks the {string} button")
	public void user_clicks_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on payment button");
	}

	@Then("user should see a payment confirmation message")
	public void user_should_see_a_payment_confirmation_message() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Payment message");
	}

	@Then("payment should be processed successfully")
	public void payment_should_be_processed_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("successfully");
	}



}
