package seleniumConc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameConc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.switchTo().frame("frame name");
//		driver.switchTo().frame(index);

		WebElement link1 = driver.findElement(
				By.xpath("//div[@class=\"col-first even-row-color all-packages-table all-packages-table-tab1\"]/a"));
		link1.click();

		driver.switchTo().defaultContent();
//		driver.switchTo().frame("frame name2");

		WebElement help = driver.findElement(By.xpath("//ul[@class=\"nav-list\"]/li[8]/a")); // (//ul[@title="Navigation"])[1]/li[8]/a
		help.click();

	}

}
