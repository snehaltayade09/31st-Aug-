package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver chromeBrowser() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// if our browser is updated that time also update automatically
		// System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		// if our browser is updated that time also update automatically
		WebDriver driver = new ChromeDriver(option);
		driver.navigate().to("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));//implicit
		// wait
		return driver;
	}

	
	}

	
	


