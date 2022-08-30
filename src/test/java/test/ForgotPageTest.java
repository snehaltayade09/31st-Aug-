package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ZerodhaForgotpage;
import utility.Parametrisation;

public class ForgotPageTest {
	WebDriver driver;
	
	@BeforeMethod
	
	public void LaunchBrowser() {
		driver= pojo.LaunchBrowser.launchBrowser();
	}
	@Test
	public void zerodhaForgetTest() throws InterruptedException, EncryptedDocumentException, IOException {
		ZerodhaForgotpage zerodhaForgotpage=new ZerodhaForgotpage (driver);
		  String ID=Parametrisation.parameterisation("Sheet2",0,1);
		  String Pan=Parametrisation.parameterisation("Sheet2",1,1);
		  String email=Parametrisation.parameterisation("Sheet2",2,1);
		  String mobileNumber=Parametrisation.parameterisation("Sheet2",3,1);
      
		  zerodhaForgotpage.clickOnforgot();
		  zerodhaForgotpage.switchForgotPage(driver);
		  Thread.sleep(2000);
		  
		  zerodhaForgotpage.clickUser();
		  zerodhaForgotpage.clickenterId(ID);
		  zerodhaForgotpage.clickPan1(Pan);
		 // zerodhaForgotpage.clickOnEmail(email);
		  Thread.sleep(4000);
		   zerodhaForgotpage.clickOnSMS();
		    zerodhaForgotpage.clickReset();
		  
		  
		  
		 	}

}
