package TestNGPractise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlretTesting {
		
		WebDriver driver;
		@BeforeMethod
		public void setUp()
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://demo.guru99.com/v4/");
			driver.manage().window().maximize();
		}
		
		@AfterMethod
		public void teardowm() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
		}
		
		@Test
		public void AlertHandlingTest() throws InterruptedException
		{
	           driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr266311");
	           driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin123$");
	           driver.findElement(By.xpath("//input[@type='submit']")).click();
	           Thread.sleep(4000);
	           
	           driver.findElement(By.xpath("//a[text()='Delete Customer'] ")).click();
	           Thread.sleep(4000);
	           
	           driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234");
	           Thread.sleep(4000);
	           
	           driver.findElement(By.xpath("//input[@type='submit']")).click();
	           Thread.sleep(4000);
	           
	          Alert alert=driver.switchTo().alert();
	          String actualalerttext=alert.getText();
	          
	          Assert.assertEquals(actualalerttext, "Do you really want to delete this Customer?");
	          alert.accept();
	          Thread.sleep(3000);
	          
	          alert.accept();
	          
		}

	

}
