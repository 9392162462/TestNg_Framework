package TestNGPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNg {

	public class FirstTestNGClass {
		
		WebDriver driver;
		@BeforeTest
		public void beforeTest() throws Throwable {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://primusbank.qedgetech.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Reporter.log("Running in befroeTest",true);
			Thread.sleep(3000);
		}
		@Test
		public void pBanking()throws Throwable {
			driver.findElement(By.xpath("(//img)[4]")).click();
			Reporter.log("Executing Pbanking Test",true);
			Thread.sleep(3000);
		}
		@Test
		public void cBanking()throws Throwable {
			driver.findElement(By.xpath("(//img)[5]")).click();
			Reporter.log("Executing cbanking Test",true);
			Thread.sleep(3000);
		}
		@Test
		public void iBanking()throws Throwable {
			driver.findElement(By.xpath("(//img)[6]")).click();
			Reporter.log("Executing ibanking Test",true);
			Thread.sleep(3000);
		}
		@AfterTest
		public void afterTest()throws Throwable {
			Thread.sleep(3000);
			driver.quit();
			Reporter.log("Running in aftertest",true);

		}
	}
}
