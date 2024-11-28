package crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

	WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			case"firefox":
				driver = new FirefoxDriver();
				break;

		default:
			Reporter.log("Browser value is not matching",true);
			break;
		}
		
	}
	@Test(dataProvider = "dp")
	
	//Explanation: The @Test annotation marks this as a test method. 
	//The dataProvider = "dp" attribute specifies that the test data will be supplied by the dp data provider method. 
	//The test takes two parameters: user and pass.
	
	
	public void veriy_Login(String user,String pass) throws Throwable {
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		String Expected ="dashboard";
		String Actual = driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
		Reporter.log("Valid username and password:::"+Expected+"       "+Actual,true);	
		}
		else
		{
			String error_message = driver.findElement(By.id("spanMessage")).getText();
			Reporter.log(error_message+"   "+Expected+"     "+Actual,true);
		}
		}
	@DataProvider
	public Object[][] dp() {
		Object login[][]= {{"Admin","Qedge123!@#"},{"test","Qedge123!@#"},
				{"Admin",""},{"Admin","Qedge123!@#"},{"","Qedge123!@#"}};
		return login;
		
		/*Explanation: The @DataProvider annotation marks this as a data provider method named dp , 
		 * 
		 * which supplies login credentials in a 2D array.*/
		
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
