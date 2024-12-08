package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.BaseClass;

public class LoginPage extends BaseClass {


	public void userLogin() {
		WebElement username = driver.findElement(By.cssSelector("input#user-name"));
		username.sendKeys(prop.getProperty("username"));
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys(prop.getProperty("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input#login-button"));
		loginBtn.click();
		
//		WebElement country=driver.findElement(By.xpath(null));
//		
//		selectDropDownByText(country,"india");
		
//		mouseHover(loginBtn);
//		alertPopup();
//		waitForExpectedElement(password);
		
//		List<WebElement>list=driver.findElements(By.xpath(null));
//		selectBoostrapDropdownValue(list,"india");

	}

	public boolean loginSuccesfully() {

		return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
	}

}
