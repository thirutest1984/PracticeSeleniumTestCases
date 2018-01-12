
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ButtonActions {

	public static void main(String[] args) throws Exception {
		
		String chrome = "D:\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chrome);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/button/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Use switchTo().frame() first them try to find the elements

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("/html/body/div/button")).click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		
		WebElement element = driver.findElement(By.linkText("view source"));
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
	}

}




