package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parametrisation;



public class HomePageTest {
	WebDriver driver;

	@BeforeMethod
	public void LaunchBrowser() throws EncryptedDocumentException, IOException {
		driver = LaunchBrowser.chromeBrowser();
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

	}

	/*
	  @Test 
	  public void SearchStockTest() { 
	  ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver); 
	  zerodhaHomePage.searchStock("Tata", driver);
	  
	  int number = zerodhaHomePage.getSearchResultNumber();
	  Assert.assertTrue(number > 0);
	  
	  }
	 */
	@Test
	public void SearchStockAndClickOnBuy() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Tata", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver,"TATAPOWER");

		zerodhaHomePage.clickOnSearchResultBuy();
		zerodhaHomePage.clickOnRegular();
		zerodhaHomePage.clickOnSearchintraday();
		zerodhaHomePage.enterQty("2");
		Thread.sleep(2000);

		zerodhaHomePage.enterPrice("324");
		 zerodhaHomePage.clickOnTriggerprice("320",driver);
		zerodhaHomePage.clickOnMarketprice();
		zerodhaHomePage.clickOnLimitPrice();
		zerodhaHomePage.clickOnmarketpricestoploss();

	}

}
