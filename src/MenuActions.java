
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MenuActions {
	
	WebDriver driver;
	
	public WebDriver driverMethod() {
		String chrome = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/menu/#default");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeTest
	public void launch() {
		driver = driverMethod();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void checkMenuItemDisabled() {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		// check that menu item is disabled
		String dis = driver.findElement(By.xpath("//*[@id=\"menu\"]/li[1]")).getAttribute("aria-disabled");
		System.out.println(dis);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"menu\"]/li[7]")).getAttribute("aria-disabled"));
		driver.switchTo().parentFrame();
	}
	
	@Test (priority=2)
	public void defaultFunctionality() throws InterruptedException {
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.id("menu")).isDisplayed());
		driver.findElement(By.id("ui-id-2")).click();
		
		// Use Mouse hover and move to the nested menu 
		Actions actions = new Actions(driver);
		WebElement mElement = driver.findElement(By.id("ui-id-4"));
//		actions.moveToElement(mElement);
//		Thread.sleep(5000);
		
		// find and click on the sub menu element
		WebElement sElement = driver.findElement(By.id("ui-id-6"));
//		Thread.sleep(5000);
//		actions.moveToElement(sElement);
//		Thread.sleep(5000);
//		actions.click().build().perform();
				
		actions.moveToElement(mElement).moveToElement(sElement).click().build().perform();
		driver.switchTo().parentFrame();
	}
	
	@Test (priority=3)
	public void mouseHover() throws Exception {
		Actions actions = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement el1 = driver.findElement(By.id("ui-id-2"));
		WebElement el2 = driver.findElement(By.id("ui-id-3"));
		WebElement el3 = driver.findElement(By.id("ui-id-4"));
		WebElement el4 = driver.findElement(By.id("ui-id-5"));
		WebElement el5 = driver.findElement(By.id("ui-id-9"));
		
		actions.moveToElement(el1);
		Thread.sleep(3000);
		actions.moveToElement(el2);
		Thread.sleep(3000);
		actions.moveToElement(el3);
		Thread.sleep(3000);
		actions.moveToElement(el4);
		Thread.sleep(3000);
		actions.moveToElement(el5);
		Thread.sleep(3000);		

	}

}
