
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DialogActions {
	
	WebDriver driver;
	
	public WebDriver driverMethod() throws Exception {
		String path = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/dialog/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeTest
	public void open() throws Exception {
		driver=driverMethod();		
	}
	
	@AfterTest
	public void close() {
		driver.quit();		
	}
	
	@Test
	public void basicDialog() throws Exception {
		driver.findElement(By.xpath("//*[@class='demo-list']/ul/li[2]")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("opener")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.id("ui-id-1")).isDisplayed());
		Thread.sleep(3000);		
		driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(false, driver.findElement(By.id("ui-id-1")).isDisplayed());
		driver.switchTo().parentFrame();
	}
	
	@Test
	public void modelConfirmation() {
		driver.findElement(By.linkText("Modal confirmation")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//driver.findElement(By.id("dialog-confirm")).isDisplayed();
		driver.findElement(By.xpath("//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-buttons ui-draggable']")).isDisplayed();
		
	}

}
