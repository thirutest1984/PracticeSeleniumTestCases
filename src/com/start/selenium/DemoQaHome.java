package com.start.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQaHome {
	
	@Test
	public void BasicTest() throws Exception {
		
		String chrome = "D:\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chrome);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"post-9\"]/header/h1"));
//		String title = element.getAttribute("innerHTML");
//		System.out.println(title);
//		Assert.assertEquals(title, "Home");
//		boolean res = element.isDisplayed();
//		System.out.println(res);
//		Assert.assertEquals(res, true);
//		driver.findElement(By.xpath("//div[@class='detail-entry'][1]")).click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.navigate().back();
//		System.out.println("go back to demo");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.navigate().forward();
//		System.out.println("go to image");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.navigate().to("http://demoqa.com/");
//		System.out.println("go back to demo");
		
		// clicking on tab
		driver.findElement(By.id("ui-id-2")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//je.executeScript("window.scrollBy(0,200)");
		je.executeAsyncScript("arguments[0].scrollIntoView(true)",driver.findElement(By.id("footer-widget-1")));
		//driver.close();
		driver.quit();
	}

}
