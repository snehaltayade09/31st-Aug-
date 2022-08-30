package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrisation;
import utility.Reports;
//@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void addReports() {
		reports=Reports.generateReports();
		
	}

	//WebDriver driver;

	@BeforeMethod
	public void LaunchBrowser() {
		driver = LaunchBrowser.chromeBrowser();

	} 

	@Test
	public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		test=reports.createTest("ZerodhaLoginTest");
		ZerodhaLoginPage zerodhaLoginpage = new ZerodhaLoginPage(driver);
		String userId = Parametrisation.parameterisation("Sheet1", 0, 1);
		String pass = Parametrisation.parameterisation("Sheet1", 1, 1);
		String pin = Parametrisation.parameterisation("Sheet1", 2, 1);

		zerodhaLoginpage.LogID(userId);
		zerodhaLoginpage.password1(pass);
		zerodhaLoginpage.clickOnSubmit();
		// Thread.sleep(2000);//bcoz we use implicit wait in launch Browser
		zerodhaLoginpage.enterPin(pin, driver);
		zerodhaLoginpage.clickOnContinue();
		Assert.assertTrue(false);

	}
	@AfterMethod
	public void postTest(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
			
		
		{
			test.log(Status.PASS,result.getName());
		}
		else
		{
			test.log(Status.SKIP,result.getName());
		}
	}

@AfterTest
public void flushReports()
{
	reports.flush();
}
}
		
	



