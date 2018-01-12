
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SportsLogin {

	public static void main(String[] args) {
		

		String chrome  = "D:\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chrome);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://mysports.tomtom.com/app/login/?targetState=latest");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("kotra.thirumala@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test12345");
		
		driver.findElement(By.id("logInButton")).click();
		
		// Handling the new window tab
		driver.findElement(By.linkText("GET STARTED")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		Set<String> windows = driver.getWindowHandles();

		for(String handle:windows) {
			driver.switchTo().window(handle);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase("Get Started – Product Registration & Use – TomTom – Sports & Fitness")) {
				driver.close();				
			}
		}
	
	}

}
