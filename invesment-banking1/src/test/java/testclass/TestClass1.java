package testclass;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pom.classes.HomePage;
import com.pom.classes.LogInPage;
import com.pom.utilities.Utility;

import testBrowserSetup.Pojo;

public class TestClass1 extends Pojo{
	
	private WebDriver driver;
	private LogInPage LogIn;
	private HomePage hp;
	int testID;
	
	
	
	@BeforeTest
	@Parameters("browser")
	public void lauchBrowser(String browser) throws InterruptedException {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");

		
		if(browser.equalsIgnoreCase("Chrome")){
			driver= openCromebrowser();
		}
		else
			if(browser.equalsIgnoreCase("Firefox")) {
				driver= openFirefoxBrowser();
			}
          Thread.sleep(5000);
		//edited
	}
	
	
	@BeforeClass
	public void beforeClass() {
	driver.get("http://localhost/login.do");
	}

	
	
	@BeforeMethod 
	public void beforeMethode() {
		LogIn=new LogInPage(driver);
		LogIn.sendDataToUser();
		LogIn.sendDataToPass();
		LogIn.clickOnLogin();
		
	}
	
	@Test(priority=1)
	public void ToVerifyTaskBtn() {
		testID=101;
		hp=new HomePage(driver);
		hp.ClickOnTask();
		String url=driver.getCurrentUrl();
		if(url.equals("http://localhost/tasks/otasklist.do")) {
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		
		}	
	}
	
	@Test
	public void ToVerifyReportBtn() {
		testID=102;
		hp=new HomePage(driver);
		hp.ClickOnReport();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost//reports.do");
		
	}
	
	@Test
	public void ToVerifyWorkSchdlBtn() throws InterruptedException {
		testID=103;
		hp=new HomePage(driver);
		hp.ClickOnWorkSchdl();
		Thread.sleep(2000);
	}
	


	@AfterMethod
		public void logoutActiTime(ITestResult result) throws InterruptedException, IOException {
			if(ITestResult.FAILURE==result.getStatus())
			{
				Utility.takesScreenShot(driver, testID);
			}
			
			Thread.sleep(3000);
		hp=new HomePage(driver);
		hp.ClickOnLogout();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	@AfterTest
	public void afterTest() {
		
					System.out.println("after SChanges");

		
	}
	
	
	
	
	
}
