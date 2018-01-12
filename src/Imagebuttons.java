
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Imagebuttons {
	
	WebDriver driver;
	
	public WebDriver methodDriver() throws Exception {
		String chrome = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/button/#default");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeTest
	public void initDriver() throws Exception {
		driver = methodDriver();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void clickIconsCategory() throws Exception {	
		driver.findElement(By.linkText("Icons")).click();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (priority=2)
	public void buttonWithOnlyText() throws Exception {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("/html/body/div[1]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
	}
	
	@Test (priority=3)
	public void buttonWithIconOnly() throws Exception {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("/html/body/div[1]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
	}
	
	@Test (priority=4)
	public void buttonWithIconOnTheBottom() throws Exception {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/button[6]"));
		element.click();
		Thread.sleep(5000);
	}
}

