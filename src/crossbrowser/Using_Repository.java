package crossbrowser;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Using_Repository {
	
		Properties conpro;
		WebDriver driver;
		@BeforeMethod
		public void setUp()throws Throwable
		{
			conpro = new Properties();
			//load file
			conpro.load(new FileInputStream("propertyFile.properties"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(conpro.getProperty("EnterUser"));
			driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(conpro.getProperty("EnterPass"));
			driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
			
		}
		@Test
		public void branchCreation() throws Throwable
		{
			driver.findElement(By.xpath(conpro.getProperty("ObjBrances"))).click();
			driver.findElement(By.xpath(conpro.getProperty("ObjNewBranch"))).click();
			driver.findElement(By.xpath(conpro.getProperty("ObjBranchName"))).sendKeys(conpro.getProperty("EnterBranchname"));
			driver.findElement(By.xpath(conpro.getProperty("ObjAddress1"))).sendKeys(conpro.getProperty("EnterAddress1"));
			driver.findElement(By.xpath(conpro.getProperty("ObjAddress2"))).sendKeys(conpro.getProperty("EnterAddress2"));
			driver.findElement(By.xpath(conpro.getProperty("ObjAddress3"))).sendKeys(conpro.getProperty("EnterAddress3"));
			driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys(conpro.getProperty("EnterArea"));
			driver.findElement(By.xpath(conpro.getProperty("Objzipcode"))).sendKeys(conpro.getProperty("Enterzipcode"));
			new Select(driver.findElement(By.xpath(conpro.getProperty("Objcountry")))).selectByVisibleText(conpro.getProperty("selectCountry"));
			new Select(driver.findElement(By.xpath(conpro.getProperty("Objstate")))).selectByVisibleText(conpro.getProperty("selectstate"));
			new Select(driver.findElement(By.xpath(conpro.getProperty("Objcity")))).selectByVisibleText(conpro.getProperty("selectcity"));
			Thread.sleep(2000);
			driver.findElement(By.xpath(conpro.getProperty("Objsubmit1"))).click();
			Thread.sleep(2000);
			String alert_text = driver.switchTo().alert().getText();
			Reporter.log(alert_text,true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
		}
		@Test
		public void roleCreation() throws Throwable
		{
			driver.findElement(By.xpath(conpro.getProperty("ObjRoles"))).click();
			driver.findElement(By.xpath(conpro.getProperty("ObjnewRole"))).click();
			driver.findElement(By.xpath(conpro.getProperty("Objrolename"))).sendKeys(conpro.getProperty("Enterrole"));
			driver.findElement(By.xpath(conpro.getProperty("ObjroleDesc"))).sendKeys(conpro.getProperty("Enterroledesc"));
			new Select(driver.findElement(By.xpath(conpro.getProperty("Objroletype")))).selectByVisibleText(conpro.getProperty("selectroletye"));
			driver.findElement(By.xpath(conpro.getProperty("Objsubmit"))).click();
			Thread.sleep(2000);
			String alert_text = driver.switchTo().alert().getText();
			Reporter.log(alert_text,true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		}

		


