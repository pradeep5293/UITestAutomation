package stepDefinition;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import helper.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginPageSteps{

	LoginPage login = new LoginPage();

//	@Given("user launch site url")
//	public void user_launch_site_url() {
//		// Write code here that turns the phrase above into concrete actions
//		launchUrl();
//	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		login.userLogin();
	}

	@Then("validate succesfully")
	public void validate_succesfully() {
		assertTrue("validate successful", login.loginSuccesfully());

	}
	@Then("validate unsuccesfully")
	public void validate_unsuccesfully() {
		assertTrue("validate successful", login.loginSuccesfully());

	}

}
