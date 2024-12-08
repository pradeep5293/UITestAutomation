package seleniumConc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement productManu=driver.findElement(By.xpath("//button[@id=\"products-dd-toggle\"]"));
		
		//for hover mouse
		Actions ac=new Actions(driver);
//		ac.doubleClick();
//		ac.dragAndDrop(productManu, productManu);
//		ac.click();
		
		ac.moveToElement(productManu).build().perform();
		WebElement live=driver.findElement(By.xpath("//a[@href='/live']"));
		live.click();
		
		WebElement searchIcon=driver.findElement(By.xpath("//button[@aria-label='Search']"));   
		
//		searchIcon.click();
		WebElement searchWord=driver.findElement(By.cssSelector("input#doc-search-box-input"));
		searchWord.sendKeys("Test");
		//call to action perform
		ac.sendKeys(Keys.ENTER).build().perform();
		driver.close();
		
		
	}

}
