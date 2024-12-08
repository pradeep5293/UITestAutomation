package seleniumConc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class AlertPop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
//		WebElement btn=driver.findElement(By.cssSelector("button#alertBox"));
		WebElement btn=driver.findElement(By.cssSelector("button#promptBox"));
//		btn.click();
		//or
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();",btn);
		
		js.executeScript("arguments[0].scrollIntoView(true);", btn);
		js.executeScript("arguments[0].click();",btn);
		
		Alert alert=driver.switchTo().alert();
		
		String st=alert.getText();
		System.out.println(st);
		
//		alert.accept(); 	//for ok
//		alert.dismiss();    //for cancel
		
		alert.sendKeys("Test Alert");
		alert.accept();

	}

}
