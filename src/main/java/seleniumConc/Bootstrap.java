package seleniumConc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Bootstrap {

	/*
	 * public void bootstrapDropdown() { WebDriver driver = new ChromeDriver();
	 * driver.get(
	 * "https://bugbug.io/blog/testing-frameworks/best-selenium-practice-websites");
	 * driver.manage().window().maximize(); WebElement btn = driver
	 * .findElement(By.cssSelector(
	 * "button.ContentMenu_ContentMenu__rootMenuItemAnchor__JEKhK")); btn.click();
	 * List<WebElement> list = driver .findElements(By.
	 * cssSelector("ul.ContentMenu_ContentMenu__nestedMenu__YGG1z li a")); for
	 * (WebElement e : list) { String val = e.getText(); System.out.println(val);
	 * int size=list.size(); System.out.println(size); } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Bootstrap boot = new Bootstrap();
//		boot.bootstrapDropdown();

		WebDriver driver = new ChromeDriver();
		driver.get("https://bugbug.io/blog/testing-frameworks/best-selenium-practice-websites");
		driver.manage().window().maximize();
		WebElement btn = driver
				.findElement(By.cssSelector("button.ContentMenu_ContentMenu__rootMenuItemAnchor__JEKhK"));
		btn.click();
		List<WebElement> list = driver
				.findElements(By.cssSelector("ul.ContentMenu_ContentMenu__nestedMenu__YGG1z li a"));

		int size = list.size();
		System.out.println(size);

		for (WebElement e : list) {
			String val = e.getText();
			System.out.println(val);

			if (val.equals("Roadmap")) {
				e.click();
			}
		}

	}

}
