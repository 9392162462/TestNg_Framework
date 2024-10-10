package TestNGPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestNg {
	

	WebDriver driver;
	@BeforeMethod
	public void setUp() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		Reporter.log("Running in beforemethod",true);
		Thread.sleep(2000);
	}
	@Test
	public void branches()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing branches test",true);
		Thread.sleep(3000);
	}
	@Test
	public void roles()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing roles test",true);
		Thread.sleep(3000);
	}
	@Test
	public void users()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Executing users test",true);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown() throws Throwable
	{
		Thread.sleep(3000);
		driver.quit();
		Reporter.log("Running in Aftermethod",true);
	}
	

}
