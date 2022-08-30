package utility;



import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;




public class Listneners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.print("Test Started" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
			ScreenShot.takeScreenShot(driver,result.getName());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped" + result.getName());
	}

}
