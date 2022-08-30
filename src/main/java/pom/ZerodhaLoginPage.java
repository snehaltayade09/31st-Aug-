package pom;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {

	@FindBy(xpath = "//input[@id='userid']")private WebElement loginID;
	@FindBy(xpath = "//input[@id='password']")private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")private WebElement submit;
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy(xpath = "//input[@id='pin']")private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']")private WebElement submitpin;

	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void LogID(String ID) {
		loginID.sendKeys(ID);
	}

	public void password1(String pass) {
		password.sendKeys(pass);
	}

	public void clickOnSubmit() {
		submit.click();
	}

	public void clickOnForgot() {
		forgot.click();
	}

	public void enterPin(String PinNumber,WebDriver driver) {
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait until(ExpectedCondition.visibilityOf(pin));*/  //explicitn wait
        FluentWait<WebDriver>wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(2000));//This is maximum  time of wait
		wait.pollingEvery(Duration.ofMillis(100));//this is pooling time
		wait.ignoring(Exception.class);//this will handel exception
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(PinNumber);
	}

	public void clickOnContinue() {
		submitpin.submit();
	}
}
