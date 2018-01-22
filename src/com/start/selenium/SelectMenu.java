package com.start.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectMenu {
	
	WebDriver driver;
	
	public WebDriver driverMethod() throws Exception {
		String path = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectmenu/");
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
	public void selectMenuItem() throws Exception {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Thread.sleep(5000);

//		Select select = new Select(driver.findElement(By.id("speed")));
//		List<WebElement> list = select.getOptions();
//		for(WebElement item:list) {
//			String value = item.getAttribute("innerHTML");
//			
//			System.out.println(value);
		
		Select dropDown = new Select(driver.findElement(By.id("speed")));
		dropDown.selectByVisibleText("Slow");
		}
}
