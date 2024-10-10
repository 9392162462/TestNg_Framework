package TestNGPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumprdTesting {
	

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void teardowm() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 0)
	public void AlertHandlingTest() throws InterruptedException
	{
           driver.findElement(By.xpath("//input[@id='email_field']")).sendKeys("admin123@gmail.com");
           driver.findElement(By.xpath("//input[@id='password_field']")).sendKeys("admin123");
           driver.findElement(By.xpath("//button[@onclick='login()']")).click();
           Thread.sleep(4000);
	}
	public void mouseHoverTestDemo1() throws InterruptedException
	{
	
		try {
		 WebElement e=driver.findElement(By.xpath("//button[normalize-space()='Switch To']"));

		 e.click();

           Actions action=new Actions(driver);
		   action.moveToElement(e).perform();
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//a[normalize-space()='Alert']"));
		   Thread.sleep(4000);
		   action.pause(5).click( driver.findElement(By.xpath("//a[normalize-space()='Alert']"))).build().perform();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		         
		
	}
	
}
