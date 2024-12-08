package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	static {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\com.NDC\\src\\main\\java\\resourses\\env.properties");
			prop = new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before // precondition
	public void launchUrl() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@After // post condition
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot t = (TakesScreenshot) driver;
			File file = t.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(file, new File("Screenshots/" + s.getName() + ".png"));
		}
		driver.quit();
	}

	public void selectDropDownByText(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByVisibleText(value);
//		s.selectByValue(value);
	}

	public void selectDropDownByIndex(WebElement ele, int num) {
		Select s = new Select(ele);
		s.selectByIndex(num);
	}

	public void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	public void alertPopup() {
		Alert a = driver.switchTo().alert();
		a.accept();
//		a.dismiss();
	}

	public void waitForExpectedElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectBoostrapDropdownValue(List<WebElement> dropdown, String exptectedValue) {
		for (WebElement e : dropdown) {
			String value = e.getText();

			if (value.equals(exptectedValue)) {
				e.click();
				break;
			}
		}
	}
	public void  javaScriptClick(WebElement ele) {
		JavascriptExecutor  js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}
	public void click(WebElement ele) {
		try {
			ele.click();
		}catch(Exception e) {
			javaScriptClick(ele);
		}
	}
}
