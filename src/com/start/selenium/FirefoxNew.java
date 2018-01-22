package com.start.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxNew {

	public static void main(String[] args) {
		
		String path = "D:\\geckodriver-v0.18.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", path);

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
	}

}
