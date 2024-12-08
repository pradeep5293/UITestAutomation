package seleniumConc;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		String parentId = driver.getWindowHandle();
		System.out.println(parentId);

		WebElement btn1 = driver.findElement(By.cssSelector("button#newWindowBtn"));
		btn1.click();
		Set<String> allwindow = driver.getWindowHandles(); // parent id+child id

		for (String s : allwindow) {
			if (!parentId.equals(s)) {
				driver.switchTo().window(s);
//				break;
				WebElement fname = driver.findElement(By.cssSelector("input#firstName"));

				fname.sendKeys("sk");
				driver.close();

			}

		}
		driver.switchTo().window(parentId);
		WebElement name = driver.findElement(By.cssSelector("input#name"));
		name.sendKeys("test");
	}

}
