package seleniumConc;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //apply implicit wait
		driver.manage().window().maximize();
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);

		WebElement btn1 = driver.findElement(By.cssSelector("button#newTabsBtn"));
		btn1.click();
		Set<String> allWindow = driver.getWindowHandles();

		for (String s : allWindow) {
//			System.out.println(s);
			if (!parentId.equals(s)) {
				driver.switchTo().window(s);

				String title = driver.getTitle();
				if (title.equals("AlertsDemo - H Y R Tutorials")) {
					WebElement alertBtn = driver.findElement(By.cssSelector("button#alertBox"));
					
					WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   //Explicit wait
					wait.until(ExpectedConditions.elementToBeClickable(alertBtn));
					
					alertBtn.click();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					break;
				}
			}
		}

	}

}
