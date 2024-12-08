package seleniumConc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v127.css.CSS;s

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch2 {

	public void browserSetUp() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://portal.nysc.org.ng/nysc1/ResumePayment.aspx");
		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtemailAddress"));
		email.sendKeys("AutomateEmail");

		WebElement password = driver.findElement(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtPassCode"));
		password.sendKeys("AutomatePassword");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnResume']"));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Automation test");
		BrowserLaunch2 browser = new BrowserLaunch2();
		browser.browserSetUp();

	}

}
