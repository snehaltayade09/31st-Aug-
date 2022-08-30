 package pom;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotpage {
	@FindBy(xpath ="//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy(xpath="(//Form//label)[1]") private WebElement rememberUser;
	@FindBy(xpath="(//Form//label)[2]") private WebElement forgotUser;
	@FindBy(xpath="(//Form//label)[3]") private WebElement userID;
    @FindBy(xpath="(//Form//label)[4]") private WebElement pan;
    @FindBy(xpath="(//Form//label)[5]") private WebElement receiveEmail;
    @FindBy(xpath="(//Form//label)[6]") private WebElement receiveSMS;
    @FindBy(xpath="(//Form//label)[7]") private WebElement email;
    @FindBy(xpath=" //button[@type='submit']") private WebElement reset;
    
    
    
    public ZerodhaForgotpage (WebDriver driver) {
		PageFactory.initElements(driver, this);
        }
       
    public void clickOnforgot() {
    	forgot.click();
    		
    	}
    
    
    public void clickUser() {
    rememberUser.click();
    }
    
    public void clickforgot() {
    forgotUser.click();
    	 }
    public void clickenterId(String ID) {
    	userID.sendKeys(ID);
    }
     public void clickPan1(String Pan) {
    	 pan.sendKeys(Pan);
     }
     
     public void clickEmail() {
    	 receiveEmail.click();
     }
     public void clickOnSMS() {
    	 receiveSMS.click();
     }
     public void clickOnEmail(String mail) {
    	 email.sendKeys(mail);
     }
     
     public void clickReset() {
    	 reset.click();
     }
     
     
     
     public void switchForgotPage(WebDriver driver) {
    	 Set<String>handels=driver.getWindowHandles();
    	 Iterator<String>i=handels.iterator();
    	 while(i.hasNext()) {
    		 String popUp=i.next();
    		 driver.switchTo().window(popUp);
    		 String title=driver.getTitle();
    		 
    		 if(title.equals("https://kite.zerodha.com/forgot"))
    		 {
    			 break;
    		 }
    			 } }
     }
