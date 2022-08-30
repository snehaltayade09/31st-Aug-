package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	@FindBy(xpath = "//input[@type='text']") private WebElement search;
	@FindBy(xpath = "//span[@class='tradingsymbol']")private List<WebElement> searchResult;
    @FindBy(xpath="//button[@class='button-blue']") private WebElement searchBuy;
    @FindBy(xpath="(//label[@class='su-radio-label'])[1]") private WebElement BSE;
    @FindBy(xpath="(//label[@class='su-radio-label'])[2]") private WebElement Regular;
    @FindBy(xpath="//div[@class='drag-handle']") private WebElement Intraday;
    @FindBy(xpath="(//input[@type='number'])[1]") private WebElement Qty;
    @FindBy(xpath="(//input[@type='number'])[2]") private WebElement Price;
    @FindBy(xpath="(//input[@type='number'])[3]") private WebElement Triggerprice;
    @FindBy(xpath="(//label[@class='su-radio-label'])[9]") private WebElement BuyatMarketPrice;
    @FindBy(xpath="(//label[@class='su-radio-label'])[10]")private WebElement BuyLimitPrice;
    @FindBy(xpath="(//label[@class='su-radio-label'])[11]")private WebElement Buystoploss;
    @FindBy(xpath="(//label[@class='su-radio-label'])[12]")private WebElement Buyatmarketpricestoploss;
   
    
    
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void searchStock(String stock, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);

	}

	public int getSearchResultNumber() {
		int listSize = searchResult.size();
		return listSize;
	}

	public void searchAndSelectDesiredStock(WebDriver driver, String RequiredStock) {
		for (int a = 0; a < searchResult.size(); a++) {

			WebElement s = searchResult.get(a);
			String StockName = s.getText();
			if (StockName.equals(RequiredStock)) {
				Actions action = new Actions(driver);
				action.moveToElement(s);
				action.perform();
				break;
			}

		}
       
	
		
	}
	public void clickOnSearchResultBuy()
	{
		
		searchBuy.click();
	}
	public void clickOnRegular() {
		Regular.click();
	}
	
public void clickOnSearchintraday() {
	Intraday.click();
}
public void enterQty(String qty) {
	Qty.sendKeys(qty);
}
public void enterPrice(String price) {
	Price.sendKeys(price);
}
public void clickOnTriggerprice(String tprice,WebDriver driver) {
	Triggerprice.sendKeys(tprice);
}
public void clickOnMarketprice() {
	BuyatMarketPrice.click();
}
  public void clickOnLimitPrice() {
	  BuyLimitPrice.click();
  }
  public void clickOnStopLoss() {
  Buystoploss.click();
}
  public void clickOnmarketpricestoploss() {
	  Buyatmarketpricestoploss.click();
  }
  
}
