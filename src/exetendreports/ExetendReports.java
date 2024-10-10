package exetendreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExetendReports {
		WebDriver driver;
		ExtentReports reports;
		ExtentTest logger;
		@BeforeTest
		public void generateReport()
		{
			reports = new ExtentReports("./ExtentReports/demo.html");
		}
		@BeforeMethod
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https:/google.com");
		}
		@Test
		public void passTest()
		{
			logger = reports.startTest("Test Pass");
			logger.assignAuthor("hari");
			String Expected ="Google";
			String Actual = driver.getTitle();
			if(Actual.equalsIgnoreCase(Expected))
			{
				logger.log(LogStatus.PASS, "Title is Matching::"+Expected+"    "+Actual);
			}
			else
			{
				logger.log(LogStatus.FAIL, "Title is Not  Matching::"+Expected+"    "+Actual);	
			}
			
		}
		@Test
		public void FailTest()
		{
			logger = reports.startTest("Test Fail");
			logger.assignAuthor("hari");
			String Expected ="Gmail";
			String Actual = driver.getTitle();
			if(Actual.equalsIgnoreCase(Expected))
			{
				logger.log(LogStatus.PASS, "Title is Matching::"+Expected+"    "+Actual);
			}
			else
			{
				logger.log(LogStatus.FAIL, "Title is Not  Matching::"+Expected+"    "+Actual);	
			}
			
		}
		@AfterMethod
		public void tearDown()
		{
			reports.endTest(logger);
			reports.flush();
			driver.quit();
		}
		}

