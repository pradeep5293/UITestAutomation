package seleniumConc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public void initialization() {
		WebDriverManager.chromedriver().setup(); // to match the browser version and driver version
		
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--remote-allow-origin=*");
//		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(); // chrome browser launch
		driver.get("https://in.pinterest.com/login/"); // launch url to automate
		driver.manage().window().maximize(); // maximize the browser(screen)

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("Test Automation");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //apply implicit wait
		
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("Test automation");

		WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));    //Explicit wait
		wait.until(ExpectedConditions.invisibilityOf(loginBtn));
		loginBtn.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserLaunch browser = new BrowserLaunch();
		browser.initialization();

	}

}
