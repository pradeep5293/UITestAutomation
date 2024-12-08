package seleniumConc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public void dropdownSetup() {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
//		WebElement dropdown=driver.findElement(By.cssSelector("select#course"));
//		
//		
//		Select st=new Select(dropdown);
////		st.selectByVisibleText("Python");   //method one to select
//		st.selectByValue("java");
////		st.selectByIndex(4);
		
		//select  the multiple value in dropdown
		
		WebElement multiDropdown=driver.findElement(By.cssSelector("select#ide"));
		Select s=new Select(multiDropdown);
		s.selectByVisibleText("Eclipse");
		s.selectByVisibleText("Visual Studio");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dropdown dd=new Dropdown();
		dd.dropdownSetup();

	}

}
