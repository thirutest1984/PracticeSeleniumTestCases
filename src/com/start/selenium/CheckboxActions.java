package com.start.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxActions {
	
	WebDriver driver;
	
	public WebDriver driverMethod() throws Exception {
		String path = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/checkboxradio/");
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
	public void radioGroup() throws Exception {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//fieldset[1]/label[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//fieldset[1]/label[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//fieldset[1]/label[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//fieldset[2]/label[3]")).click();
		Thread.sleep(3000);
	}

}

